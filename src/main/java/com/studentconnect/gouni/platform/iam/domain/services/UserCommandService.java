package com.studentconnect.gouni.platform.iam.domain.services;

import com.studentconnect.gouni.platform.iam.domain.model.aggregates.User;
import com.studentconnect.gouni.platform.iam.domain.model.commands.SignInCommand;
import com.studentconnect.gouni.platform.iam.domain.model.commands.SignUpCommand;
import java.util.Optional;
import org.apache.commons.lang3.tuple.ImmutablePair;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);

}
