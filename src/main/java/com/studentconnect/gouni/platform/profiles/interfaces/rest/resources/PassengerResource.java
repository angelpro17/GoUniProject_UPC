package com.studentconnect.gouni.platform.profiles.interfaces.rest.resources;

public record PassengerResource(Long id,
                                String name,
                                String email,
                                Long dni,
                                Long phone,
                                String photo) {
}
