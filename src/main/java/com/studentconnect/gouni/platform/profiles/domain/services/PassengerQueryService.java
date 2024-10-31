package com.studentconnect.gouni.platform.profiles.domain.services;

import com.studentconnect.gouni.platform.profiles.domain.model.aggregates.Passenger;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetAllPassengersQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetPassengerByIdQuery;

import java.util.List;
import java.util.Optional;


public interface PassengerQueryService {
    Optional<Passenger> handle(GetPassengerByIdQuery query);
    List<Passenger> handle(GetAllPassengersQuery query);
}
