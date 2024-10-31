package com.studentconnect.gouni.platform.profiles.domain.services;


import com.studentconnect.gouni.platform.profiles.domain.model.aggregates.Profile;
import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}