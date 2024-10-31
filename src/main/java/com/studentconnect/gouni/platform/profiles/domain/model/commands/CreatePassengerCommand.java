package com.studentconnect.gouni.platform.profiles.domain.model.commands;

public record CreatePassengerCommand(String name,
                                     String email,
                                     Long dni,
                                     Long phone,
                                     String photo) {}
