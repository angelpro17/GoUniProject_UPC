package com.studentconnect.gouni.platform.profiles.interfaces.acl;

import com.studentconnect.gouni.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.EmailAddress;
import com.studentconnect.gouni.platform.profiles.domain.services.ProfileCommandService;
import com.studentconnect.gouni.platform.profiles.domain.services.ProfileQueryService;
import org.springframework.stereotype.Service;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetPassengerByIdQuery;
import com.studentconnect.gouni.platform.profiles.domain.model.queries.GetDriverByIdQuery;
import com.studentconnect.gouni.platform.profiles.domain.services.PassengerCommandService;
import com.studentconnect.gouni.platform.profiles.domain.services.PassengerQueryService;
import com.studentconnect.gouni.platform.profiles.domain.services.DriverCommandService;
import com.studentconnect.gouni.platform.profiles.domain.services.DriverQueryService;

/**
 * Service Facade for the Profile context.
 *
 * <p>
 * It is used by the other contexts to interact with the Profile context.
 * It is implemented as part of an anti-corruption layer (ACL) to be consumed by other contexts.
 * </p>
 *
 */
@Service
public class ProfilesContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;
    private final DriverCommandService driverCommandService;
    private final DriverQueryService driverQueryService;
    private final PassengerCommandService passengerCommandService;
    private final PassengerQueryService passengerQueryService;



    public ProfilesContextFacade(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService,DriverCommandService driverCommandService, DriverQueryService driverQueryService,
                                 PassengerCommandService passengerCommandService,PassengerQueryService passengerQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
        this.driverCommandService = driverCommandService;
        this.driverQueryService = driverQueryService;
        this.passengerCommandService = passengerCommandService;
        this.passengerQueryService = passengerQueryService;
    }

    /**
     * Creates a new Profile
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param email the email
     * @param street the street address
     * @param number the number
     * @param city the city
     * @param state the state
     * @param zipCode the zip code
     * @return the profile id
     */
    public Long createProfile(String firstName, String lastName, String email, String street, String number, String city, String state, String zipCode) {
        var createProfileCommand = new CreateProfileCommand(firstName, lastName, email, street, number, city, state, zipCode);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

    /**
     * Fetches the profile id by email
     *
     * @param email the email
     * @return the profile id
     */
    public Long fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();

    }
    public Long fetchPassengerIdById(Long passengerId){
        var getPassengerByIdQuery = new GetPassengerByIdQuery(passengerId);
        var passenger = passengerQueryService.handle(getPassengerByIdQuery);
        if (passenger.isEmpty()) return 0L;
        return passenger.get().getId();
    }

    public Long fetchDriverIdById(Long driverId){
        var getDriverByIdQuery = new GetDriverByIdQuery(driverId);
        var driver = driverQueryService.handle(getDriverByIdQuery);
        if (driver.isEmpty()) return 0L;
        return driver.get().getId();
    }

}