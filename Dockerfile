# Use a base image with both Maven and Gradle
FROM adoptopenjdk:22-jdk-hotspot as build

# Install Maven and Gradle
RUN apt-get update && \
    apt-get install -y maven gradle && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Attempt to build with Maven first, if it fails, try Gradle
RUN if [ -f "pom.xml" ]; then \
        echo "Building with Maven" && \
        mvn clean package -DskipTests; \
    elif [ -f "build.gradle" ]; then \
        echo "Building with Gradle" && \
        gradle clean build --no-daemon; \
    else \
        echo "No pom.xml or build.gradle found" && \
        exit 1; \
    fi

# Use a slim JRE image for the final stage
FROM adoptopenjdk:22-jre-hotspot

WORKDIR /app

# Copy the built artifact from the build stage
# Adjust the path based on your project structure
COPY --from=build /app/target/*.jar app.jar
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]