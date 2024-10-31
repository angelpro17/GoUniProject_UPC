package com.studentconnect.gouni.platform.profiles.domain.services;

import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateReviewCommand;
import com.studentconnect.gouni.platform.profiles.domain.model.entities.Review;

public interface ReviewCommandService {
    Review handle(CreateReviewCommand command);
}
