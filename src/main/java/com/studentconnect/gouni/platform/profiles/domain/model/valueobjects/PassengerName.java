package com.studentconnect.gouni.platform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PassengerName(String passengerName) {
    public PassengerName() {
        this(null);
    }

    // name cannot be null or blank
    public PassengerName {
        if (passengerName == null || passengerName.isBlank()) {
            throw new IllegalArgumentException("Passenger name cannot be null or blank");
        }
    }

    public String getFullName() {
        return passengerName;
    }
}
