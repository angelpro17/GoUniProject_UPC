package com.studentconnect.gouni.platform.carpooling.interfaces.rest.transform;

import com.studentconnect.gouni.platform.carpooling.domain.model.commands.CreateStudentCommand;
import com.studentconnect.gouni.platform.carpooling.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource) {
        return new CreateStudentCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.street(),
                resource.number(),
                resource.city(),
                resource.postalCode(),
                resource.country()
        );
    }
}
