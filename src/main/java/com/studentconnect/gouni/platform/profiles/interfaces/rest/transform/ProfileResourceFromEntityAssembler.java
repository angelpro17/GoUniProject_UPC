package com.studentconnect.gouni.platform.profiles.interfaces.rest.transform;

import com.studentconnect.gouni.platform.profiles.domain.model.aggregates.Profile;
import com.studentconnect.gouni.platform.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getEmailAddress(), entity.getFullName(), entity.getStreetAddress());
    }
}