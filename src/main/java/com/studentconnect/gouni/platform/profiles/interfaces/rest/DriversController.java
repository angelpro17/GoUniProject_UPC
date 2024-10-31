package com.studentconnect.gouni.platform.profiles.interfaces.rest;

import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetAllDriverImagesByDriverIdQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetAllDriversQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetDriverByIdQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetDriverByNameQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.DriverName;
import com.studentconnect.gouni.platform.profiles.domain.services.DriverCommandService;
import com.studentconnect.gouni.platform.profiles.domain.services.DriverQueryService;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.CreateDriverImageResource;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.CreateDriverResource;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.DriverImageResource;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.DriverResource;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.transform.CreateDriverImageCommandFromResource;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.transform.CreateDriverCommandFromResourceAssembler;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.transform.DriverImageResourceFromEntityAssembler;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.transform.DriverResourceFromEntityAssembler;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.transform.UpdateDriverCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Drivers", description = "Drivers Management Endpoints")
public class DriversController {

    private final DriverQueryService driverQueryService;
    private final DriverCommandService driverCommandService;

    public DriversController(DriverQueryService driverQueryService, DriverCommandService driverCommandService) {
        this.driverQueryService = driverQueryService;
        this.driverCommandService = driverCommandService;
    }

    // crear conductor
    @PostMapping
    public ResponseEntity<DriverResource> createDriver(@RequestBody CreateDriverResource resource) {
        var createDriverCommand = CreateDriverCommandFromResourceAssembler.toCommandFromResource(resource);
        var driverId = driverCommandService.handle(createDriverCommand);
        if (driverId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getDriverByIdQuery = new GetDriverByIdQuery(driverId);
        var driver = driverQueryService.handle(getDriverByIdQuery);
        if (driver.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(driver.get());
        return new ResponseEntity<>(driverResource, HttpStatus.CREATED);
    }

    // obtener conductor por id
    @GetMapping("/{driverId}")
    public ResponseEntity<DriverResource> getDriverById(@PathVariable Long driverId) {
        var getDriverByIdQuery = new GetDriverByIdQuery(driverId);
        var driver = driverQueryService.handle(getDriverByIdQuery);
        if (driver.isEmpty()) return ResponseEntity.badRequest().build();
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(driver.get());
        return ResponseEntity.ok(driverResource);
    }

    // obtener conductor por nombre
    @GetMapping("/name/{driverName}")
    public ResponseEntity<DriverResource> getDriverByName(@PathVariable String driverName) {
        var getDriverByNameQuery = new GetDriverByNameQuery(new DriverName(driverName));
        var driver = driverQueryService.handle(getDriverByNameQuery);
        if (driver.isEmpty()) return ResponseEntity.badRequest().build();
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(driver.get());
        return ResponseEntity.ok(driverResource);
    }

    // actualizar conductor
    @PutMapping("/{driverId}")
    public ResponseEntity<DriverResource> updateDriver(
            @PathVariable Long driverId,
            @RequestBody CreateDriverResource resource) {

        // 1. Obtener el conductor existente
        var getDriverByIdQuery = new GetDriverByIdQuery(driverId);
        var existingDriver = driverQueryService.handle(getDriverByIdQuery);

        // 2. Comprobar si se encuentra
        if (existingDriver.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // 3. Crear UpdateDriverCommand
        var updateDriverCommand = UpdateDriverCommandFromResourceAssembler.toCommandFromResource(resource, driverId);

        // 4. Actualizar el conductor existente
        driverCommandService.handle(updateDriverCommand);

        // 5. Recuperar el conductor actualizado (opcional)
        var updatedDriver = existingDriver.get(); // Usar el objeto existente si no se recupera en el servicio
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(updatedDriver);

        return new ResponseEntity<>(driverResource, HttpStatus.OK);
    }

    // obtener todos los conductores
    @GetMapping
    public ResponseEntity<List<DriverResource>> getAllDrivers() {
        var getAllDriversQuery = new GetAllDriversQuery();
        var drivers = driverQueryService.handle(getAllDriversQuery);
        var driverResources = drivers.stream().map(DriverResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(driverResources);
    }

    @PostMapping("/{driverId}/images")
    public ResponseEntity<String> updateImage(@PathVariable Long driverId, @RequestBody CreateDriverImageResource resource){
        var getDriverByIdQuery = new GetDriverByIdQuery(driverId);
        var existingDrive = driverQueryService.handle(getDriverByIdQuery);
        if (existingDrive.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var createDriverCommand = CreateDriverImageCommandFromResource.ToCommandFromResource(driverId,resource);
        var result = driverCommandService.handle(createDriverCommand);
        return ResponseEntity.ok("");
    }

    @GetMapping("/{driverId}/images")
    public ResponseEntity<List<DriverImageResource>> getAllDriverImages(@PathVariable Long driverId){
        var getAllDriverImagesQuery = new GetAllDriverImagesByDriverIdQuery(driverId);
        var driverImages = driverQueryService.handle(getAllDriverImagesQuery);
        var driverResources = driverImages.stream()
                .map(DriverImageResourceFromEntityAssembler::ToResourceFromEntity)
                .toList();
        return ResponseEntity.ok(driverResources);
    }
}
