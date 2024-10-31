package com.studentconnect.gouni.platform.profiles.interfaces.rest.resources;

public record DriverResource(Long id,
                             String name,
                             String email,
                             Long license,
                             Long phone,
                             String imageProfile,
                             String description) {
}
