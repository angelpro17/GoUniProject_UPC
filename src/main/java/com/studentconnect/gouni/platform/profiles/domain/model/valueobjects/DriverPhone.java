package com.studentconnect.gouni.platform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record DriverPhone(Long driverPhone){
    // phone not null and phone length is 9
    public DriverPhone(Long driverPhone) {
        if (driverPhone != null && driverPhone.toString().length() == 9) {
            this.driverPhone = driverPhone;
        } else {
            throw new IllegalArgumentException("Phone must be 9 digits");
        }
    }

    public Long getDriverPhone() {
        return driverPhone;
    }
}
