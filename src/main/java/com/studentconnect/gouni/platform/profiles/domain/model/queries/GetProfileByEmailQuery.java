package com.studentconnect.gouni.platform.profiles.domain.model.queries;

import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
