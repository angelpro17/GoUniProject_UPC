package com.studentconnect.gouni.platform.profiles.domain.model.valueobjects;

public record DriverEmail  (
    @jakarta.validation.constraints.Email
    String email)
    {
    public DriverEmail() {
            this(null);
        }

    public DriverEmail {
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("Email cannot be null or blank");
            }
        }
}
