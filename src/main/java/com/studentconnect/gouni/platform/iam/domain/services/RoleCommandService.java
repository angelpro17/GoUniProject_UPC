package com.studentconnect.gouni.platform.iam.domain.services;

import com.studentconnect.gouni.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
