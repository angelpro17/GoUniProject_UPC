package com.studentconnect.gouni.platform.carpooling.infrastructure.persistence.jpa.repositories;


import com.studentconnect.gouni.platform.carpooling.domain.model.aggregates.Student;
import com.studentconnect.gouni.platform.carpooling.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.studentconnect.gouni.platform.carpooling.domain.model.valueobjects.UniRiderStudentRecordId;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByProfileId(ProfileId profileId);
    Optional<Student> findByUniRiderStudentRecordId(UniRiderStudentRecordId studentRecordId);
}
