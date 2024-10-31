package com.studentconnect.gouni.platform.profiles.domain.services;

import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreatePassengerCommand;
import com.studentconnect.gouni.platform.profiles.domain.model.commands.UpdatePassengerCommand;


public interface PassengerCommandService {
    Long handle(CreatePassengerCommand command);
    Long handle(UpdatePassengerCommand command);
}
