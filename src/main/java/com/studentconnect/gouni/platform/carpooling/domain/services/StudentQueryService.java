package com.studentconnect.gouni.platform.carpooling.domain.services;

import com.studentconnect.gouni.platform.carpooling.domain.model.aggregates.Student;
import com.studentconnect.gouni.platform.carpooling.domain.model.queries.GetStudentByProfileIdQuery;
import com.studentconnect.gouni.platform.carpooling.domain.model.queries.GetStudentByUniRiderStudentRecordIdQuery;

import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByProfileIdQuery query);
    Optional<Student> handle(GetStudentByUniRiderStudentRecordIdQuery query);

}
