package com.studentconnect.gouni.platform.profiles.application.internal.commandservices;

import org.springframework.stereotype.Service;
import com.studentconnect.gouni.platform.profiles.domain.model.aggregates.Driver;
import com.studentconnect.gouni.platform.profiles.domain.model.aggregates.Passenger;
import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateReviewCommand;
import com.studentconnect.gouni.platform.profiles.domain.model.entities.Review;
import com.studentconnect.gouni.platform.profiles.domain.services.ReviewCommandService;
import com.studentconnect.gouni.platform.profiles.infrastructure.persistence.jpa.repositories.PassengerRepository;
import com.studentconnect.gouni.platform.profiles.infrastructure.persistence.jpa.repositories.ReviewRepository;
import com.studentconnect.gouni.platform.profiles.infrastructure.persistence.jpa.repositories.DriverRepository;


@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final PassengerRepository passengerRepository;
    private final DriverRepository driverRepository;

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository, PassengerRepository passengerRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.passengerRepository = passengerRepository;
        this.driverRepository = driverRepository;
    }


    @Override
    public Review handle(CreateReviewCommand command) {
        // validate if passenger exists
        Passenger passenger = passengerRepository.findById(command.passengerId())
                .orElseThrow(() -> new IllegalArgumentException("Passenger not found"));

        // validate if driver exists
        Driver driver = driverRepository.findById(command.driverId())
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));

        // create review
        Review review = new Review(
                passenger,
                driver,
                command.comments(),
                command.rating()
        );

        // save review
        reviewRepository.save(review);
        return review;
    }

}
