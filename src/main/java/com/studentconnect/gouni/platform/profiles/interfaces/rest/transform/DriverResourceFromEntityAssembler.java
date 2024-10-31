package com.studentconnect.gouni.platform.profiles.interfaces.rest.transform;

import com.studentconnect.gouni.platform.profiles.domain.model.aggregates.Driver;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.DriverResource;

public class DriverResourceFromEntityAssembler {

    public static DriverResource toResourceFromEntity(Driver driver){
        return new DriverResource(
                driver.getId(),
                driver.getName(),
                driver.getEmail(),
                driver.getLicense(),
                driver.getPhone(),
                driver.getDriverImageProfile(),
                driver.getDriverDescription()
        );
    }
}
