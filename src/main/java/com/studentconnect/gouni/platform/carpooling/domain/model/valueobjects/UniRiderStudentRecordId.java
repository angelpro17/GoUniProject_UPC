package com.studentconnect.gouni.platform.carpooling.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record UniRiderStudentRecordId(String studentRecordId) {
    public UniRiderStudentRecordId() {
        this(UUID.randomUUID().toString());
    }

    public UniRiderStudentRecordId {
        if (studentRecordId == null || studentRecordId.isBlank()) {
            throw new IllegalArgumentException("Unirider user record profileId cannot be null or blank");
        }
    }
}