package com.studentconnect.gouni.platform.carpooling.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StudentPerformanceMetricSet(Integer totalRidesOffered, Integer totalRidesTaken) {
    public StudentPerformanceMetricSet() {
        this(0, 0);
    }

    public StudentPerformanceMetricSet {
        if (totalRidesOffered < 0) {
            throw new IllegalArgumentException("Total rides offered cannot be negative");
        }
        if (totalRidesTaken < 0) {
            throw new IllegalArgumentException("Total rides taken cannot be negative");
        }
    }

    public StudentPerformanceMetricSet incrementTotalRidesOffered() {
        return new StudentPerformanceMetricSet(totalRidesOffered + 1, totalRidesTaken);
    }

    public StudentPerformanceMetricSet incrementTotalRidesTaken() {
        return new StudentPerformanceMetricSet(totalRidesOffered, totalRidesTaken + 1);
    }
}
