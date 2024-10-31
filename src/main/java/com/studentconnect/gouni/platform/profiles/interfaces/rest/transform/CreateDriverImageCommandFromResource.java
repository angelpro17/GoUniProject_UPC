package com.studentconnect.gouni.platform.profiles.interfaces.rest.transform;

import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateDriverImageCommand;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.CreateDriverImageResource;
import org.springframework.stereotype.Component;

@Component
public class CreateDriverImageCommandFromResource {
    public static CreateDriverImageCommand ToCommandFromResource(Long driverId,CreateDriverImageResource resource){
        return new CreateDriverImageCommand( driverId,resource.imageUrl());
    }
}
