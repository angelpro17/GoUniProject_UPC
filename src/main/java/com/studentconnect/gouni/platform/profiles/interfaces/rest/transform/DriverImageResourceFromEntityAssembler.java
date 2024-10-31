package com.studentconnect.gouni.platform.profiles.interfaces.rest.transform;

import com.studentconnect.gouni.platform.profiles.domain.model.entities.DriverImage;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.DriverImageResource;

public class DriverImageResourceFromEntityAssembler {
    public static DriverImageResource ToResourceFromEntity(DriverImage driverImage){
        return new DriverImageResource(driverImage.getId(), driverImage.getUrl());
    }
}
