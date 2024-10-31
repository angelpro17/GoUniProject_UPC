package com.studentconnect.gouni.platform.profiles.domain.model.valueobjects;

public record PassengerEmail(
        @jakarta.validation.constraints.Email
        String email)
    {
    public PassengerEmail() {
        this(null);
    }
    public PassengerEmail {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
    }
}
