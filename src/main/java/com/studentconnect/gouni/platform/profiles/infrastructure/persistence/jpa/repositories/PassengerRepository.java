package com.studentconnect.gouni.platform.profiles.infrastructure.persistence.jpa.repositories;

import com.studentconnect.gouni.platform.profiles.domain.model.aggregates.Passenger;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.PassengerDNI;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.PassengerEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Optional<Passenger> findPassengerByPassengerDNI(PassengerDNI passengerDNI);
    Optional<Passenger> findPassengerByPassengerEmail(PassengerEmail passengerEmail);
}
