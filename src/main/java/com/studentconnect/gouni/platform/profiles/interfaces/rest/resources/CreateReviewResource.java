package com.studentconnect.gouni.platform.profiles.interfaces.rest.resources;

//record que recibe los parametro para crear un review
public record CreateReviewResource(Long driverId, Long passengerId, int rating, String comments) {}
