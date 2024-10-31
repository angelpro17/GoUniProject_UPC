package com.studentconnect.gouni.platform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PassengerDNI(Long passengerDNI) {

    public PassengerDNI {
        if (passengerDNI == null || passengerDNI.toString().length() != 8 || passengerDNI < 0) {
            throw new IllegalArgumentException("Passenger DNI cannot be null, empty, or less than 0, and must be 8 digits long.");
        }
    }

    public Long getDNI(){
        return passengerDNI;
    }
}
