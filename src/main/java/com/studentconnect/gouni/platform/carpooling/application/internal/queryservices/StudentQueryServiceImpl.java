package com.studentconnect.gouni.platform.carpooling.application.internal.queryservices;

import com.studentconnect.gouni.platform.carpooling.domain.model.aggregates.Student;
import com.studentconnect.gouni.platform.carpooling.domain.model.queries.GetStudentByProfileIdQuery;
import com.studentconnect.gouni.platform.carpooling.domain.model.queries.GetStudentByUniRiderStudentRecordIdQuery;
import com.studentconnect.gouni.platform.carpooling.domain.services.StudentQueryService;
import com.studentconnect.gouni.platform.carpooling.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of UserQueryService
 *
 * <p>
 *     This class is the implementation of the UserQueryService interface.
 *     It is used to handle queries on the User aggregate.
 * </p>
 */
@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(GetStudentByProfileIdQuery query) {
        return studentRepository.findByProfileId(query.profileId());
    }

    @Override
    public Optional<Student> handle(GetStudentByUniRiderStudentRecordIdQuery query) {
        return studentRepository.findByUniRiderStudentRecordId(query.uniRiderStudentRecordId());
    }




}
