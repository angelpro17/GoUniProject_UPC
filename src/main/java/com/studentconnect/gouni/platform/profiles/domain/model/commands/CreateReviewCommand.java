package com.studentconnect.gouni.platform.profiles.domain.model.commands;

public record CreateReviewCommand(Long driverId, Long passengerId, int rating, String comments) {
}
