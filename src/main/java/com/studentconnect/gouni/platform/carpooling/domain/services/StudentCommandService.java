package com.studentconnect.gouni.platform.carpooling.domain.services;

import com.studentconnect.gouni.platform.carpooling.domain.model.valueobjects.UniRiderStudentRecordId;
import com.studentconnect.gouni.platform.carpooling.domain.model.commands.CreateStudentCommand;
import com.studentconnect.gouni.platform.carpooling.domain.model.commands.UpdateStudentMetricsOnRideOfferedCommand;

public interface StudentCommandService {
    UniRiderStudentRecordId handle(CreateStudentCommand command);
    UniRiderStudentRecordId handle(UpdateStudentMetricsOnRideOfferedCommand command);
}
