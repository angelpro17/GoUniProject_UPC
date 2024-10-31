package com.studentconnect.gouni.platform.profiles.domain.services;

import com.studentconnect.gouni.platform.profiles.domain.model.entities.Review;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetAllReviewByDriverIdQuery;

import java.util.List;

public interface ReviewQueryService {
    List<Review> handle(GetAllReviewByDriverIdQuery query);
}
