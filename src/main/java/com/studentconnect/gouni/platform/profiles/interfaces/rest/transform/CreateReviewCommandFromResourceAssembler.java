package com.studentconnect.gouni.platform.profiles.interfaces.rest.transform;

import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateReviewCommand;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.CreateReviewResource;
import org.springframework.stereotype.Component;

@Component
public class CreateReviewCommandFromResourceAssembler {

        public CreateReviewCommand toCommandFromResource(CreateReviewResource resource) {
            return new CreateReviewCommand(
                    resource.driverId(),
                    resource.passengerId(),
                    resource.rating(),
                    resource.comments()
            );
        }
}
