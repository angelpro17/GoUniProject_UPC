package com.studentconnect.gouni.platform.profiles.domain.model.valueobjects;

public record PassengerPhone(Long passengerPhone) {

    public PassengerPhone() {
        this(null);
    }

    // phone not null and phone length is 9
    public PassengerPhone(Long passengerPhone) {
        if (passengerPhone != null && passengerPhone.toString().length() == 9) {
            this.passengerPhone = passengerPhone;
        } else {
            throw new IllegalArgumentException("Phone must be 9 digits");
        }
    }

    public Long getPhone() {
        return passengerPhone;
    }
}
