package com.studentconnect.gouni.platform.profiles.interfaces.rest.transform;

import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateDriverCommand;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.CreateDriverResource;


public class CreateDriverCommandFromResourceAssembler {

    public static CreateDriverCommand toCommandFromResource(CreateDriverResource resource) {
        return new CreateDriverCommand(
                resource.name(),
                resource.email(),
                resource.license(),
                resource.phone(),
                resource.imageProfile(),
                resource.description()
        );
    }
}
