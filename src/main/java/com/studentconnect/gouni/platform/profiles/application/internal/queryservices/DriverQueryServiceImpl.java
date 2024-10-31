package com.studentconnect.gouni.platform.profiles.application.internal.queryservices;

import com.studentconnect.gouni.platform.profiles.domain.model.aggregates.Driver;
import com.studentconnect.gouni.platform.profiles.domain.model.entities.DriverImage;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetAllDriverImagesByDriverIdQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetAllDriversQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetDriverByIdQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetDriverByNameQuery;
import com.studentconnect.gouni.platform.profiles.domain.services.DriverQueryService;
import com.studentconnect.gouni.platform.profiles.infrastructure.persistence.jpa.repositories.DriverImageRepository;
import com.studentconnect.gouni.platform.profiles.infrastructure.persistence.jpa.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverQueryServiceImpl implements DriverQueryService{

    private final DriverRepository driverRepository;

    public DriverQueryServiceImpl(DriverRepository driverRepository, DriverImageRepository driverImageRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Optional<Driver> handle(GetDriverByIdQuery query) {
        return driverRepository.findById(query.id());
    }

    @Override
    public Optional<Driver> handle(GetDriverByNameQuery query) {
        return driverRepository.findDriverByDriverName(query.driverName());
    }

    @Override
    public List<Driver> handle(GetAllDriversQuery query) {
        return driverRepository.findAll();
    }

    @Override
    public List<DriverImage> handle(GetAllDriverImagesByDriverIdQuery query) {
        var driverOpt = driverRepository.findById(query.driverId());
        if (driverOpt.isPresent()) {
            Driver driver = driverOpt.get();
            return driver.getImages();
        } else {
            throw new IllegalArgumentException("Driver not found");
        }
    }

}
