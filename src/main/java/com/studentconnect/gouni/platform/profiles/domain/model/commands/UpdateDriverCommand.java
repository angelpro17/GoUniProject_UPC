package com.studentconnect.gouni.platform.profiles.domain.model.commands;

public record UpdateDriverCommand(Long id,String name,String email,Long license,Long phone,String imageProfile,String description) {
}
