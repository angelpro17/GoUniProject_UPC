package com.studentconnect.gouni.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoUniPlatformApplication {

    public static void main(String[] args) {

        SpringApplication.run(GoUniPlatformApplication.class, args);
    }

}
