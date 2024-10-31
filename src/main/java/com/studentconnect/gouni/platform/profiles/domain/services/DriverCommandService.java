package com.studentconnect.gouni.platform.profiles.domain.services;

import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateDriverCommand;
import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateDriverImageCommand;
import com.studentconnect.gouni.platform.profiles.domain.model.commands.UpdateDriverCommand;

public interface DriverCommandService {
    Long handle(CreateDriverCommand command);
    Long handle(UpdateDriverCommand command);
    Long handle(CreateDriverImageCommand command);
}
