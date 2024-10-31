package com.studentconnect.gouni.platform.profiles.interfaces.rest;

import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateReviewCommand;
import com.studentconnect.gouni.platform.profiles.domain.model.entities.Review;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetAllReviewByDriverIdQuery;
import com.studentconnect.gouni.platform.profiles.domain.services.ReviewCommandService;
import com.studentconnect.gouni.platform.profiles.domain.services.ReviewQueryService;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.CreateReviewResource;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.ReviewResource;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.transform.CreateReviewCommandFromResourceAssembler;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.transform.ReviewResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api/v1/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reviews", description = "Reviews Management Endpoints")
public class ReviewsController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    // se usan los ensambladores explicitamente inyectados como dependencias
    private final CreateReviewCommandFromResourceAssembler createReviewCommandFromResourceAssembler;
    private final ReviewResourceFromEntityAssembler reviewsResourceFromEntityAssembler;

    public ReviewsController
            (ReviewCommandService reviewCommandService,
             ReviewQueryService reviewQueryService,
             CreateReviewCommandFromResourceAssembler createReviewCommandFromResourceAssembler,
             ReviewResourceFromEntityAssembler reviewsResourceFromEntityAssembler) {

        this.reviewCommandService = reviewCommandService;
        this.reviewQueryService = reviewQueryService;
        this.createReviewCommandFromResourceAssembler = createReviewCommandFromResourceAssembler;
        this.reviewsResourceFromEntityAssembler = reviewsResourceFromEntityAssembler;
    }

    @PostMapping
    public ResponseEntity<ReviewResource> createReview(@RequestBody CreateReviewResource createReviewResource) {
        CreateReviewCommand createReviewCommand = createReviewCommandFromResourceAssembler.toCommandFromResource(createReviewResource);
        Review review = reviewCommandService.handle(createReviewCommand);

        if (review == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Manejo de error
        }

        ReviewResource reviewResource = reviewsResourceFromEntityAssembler.toResourceFromEntity(review);
        return ResponseEntity.created(URI.create("/api/v1/reviews/" + review.getId())).body(reviewResource);
    }


    @GetMapping("/Driver/{driverId}")
    public ResponseEntity<List<ReviewResource>> getReviewsByDriverId(@PathVariable Long driverId) {
        GetAllReviewByDriverIdQuery getAllReviewByDriverIdQuery = new GetAllReviewByDriverIdQuery(driverId);

        List<Review> reviews = reviewQueryService.handle(getAllReviewByDriverIdQuery);
        List<ReviewResource> reviewResources = reviews.stream()
                .map(reviewsResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviewResources);
    }

}
