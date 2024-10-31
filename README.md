
# GoUni

GoUni is a Spring Boot application designed for **StudentConnect**, a startup that helps students find university opportunities. This project provides a management system for users, profiles, and roles, with role-based access control and MySQL database integration.

## Project Overview

### Purpose
The goal of GoUni is to create an application that connects students with university opportunities by providing a management system for users, profiles, and roles.

### Key Features
- **Profiles Management**: Manage user profiles registered within the system.
- **Roles and Security**: Implement role-based access control, such as `ROLE_USER` and `ROLE_DRIVER`, and authentication using JWT.
- **MySQL Connection**: Data persistence using MySQL as the relational database.

## Setup Instructions

Follow these steps to set up the project locally:

### 1. Clone the repository from GitHub:
```bash
git clone https://github.com/StudentConnect/GoUni.git
cd GoUni
```

### 2. Set up a local MySQL database:
- Create a database named `gouni_db`.
- Ensure the credentials in `application.properties` or `application.yml` match your MySQL setup.

### 3. Run Maven to install dependencies:
```bash
mvn clean install
```

### 4. Start the application:
```bash
mvn spring-boot:run
```

### 5. Swagger UI:
Access the API documentation at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Configuration and Environment Variables

For security and flexibility, certain configurations should be set via environment variables:

- **DB_USERNAME**: The MySQL database username.
- **DB_PASSWORD**: The MySQL database password.
- **JWT_SECRET**: The secret key for JWT token generation.
- **SPRING_PROFILES_ACTIVE**: Set the active profile (e.g., `dev`, `prod`).

Ensure these are configured before running the application.

## Maven Parent Overrides

To avoid unnecessary inheritance in the project’s `pom.xml`, you can disable certain inherited configurations if necessary.

For example, if you wish to override certain elements like `<license>` and `<developers>`, you can add empty override blocks in your `pom.xml` as shown below:

```xml
<project>
  <licenses></licenses>
  <developers></developers>
</project>
```

## Troubleshooting

If you encounter any issues during setup or runtime, consider the following steps:

### 1. Database Connection Issues:
- Verify that your MySQL database is running and that the credentials in `application.properties` or `application.yml` are correct.
- Ensure that the MySQL service is properly configured and accessible from your application.
- Check for the correct database URL format in your configuration file.

### 2. Dependency Errors:
- Make sure all dependencies are correctly installed by running:
```bash
mvn clean install
```
- Check the `pom.xml` for any missing or conflicting dependencies.

### 3. Application Fails to Start:
- Review the Spring Boot logs for error messages to diagnose startup issues.
- Check if the active profile (`dev`, `prod`, etc.) is properly set in your environment variables.
- Confirm that your port (default: 8080) is not already in use by another service.

### 4. JWT Authentication Issues:
- Ensure that the **JWT_SECRET** environment variable is set and matches the key used during token generation.
- Verify that JWT tokens are correctly formatted and not expired.

### 5. Swagger UI Not Loading:
- Ensure that the application is running on the correct port.
- Access Swagger UI at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
- Verify the `springdoc-openapi` dependency is included in the project.

## License

This project is licensed under the MIT License.
# GoUniProject_UPC
# Backend-GoUni
# Backend-GoUni
