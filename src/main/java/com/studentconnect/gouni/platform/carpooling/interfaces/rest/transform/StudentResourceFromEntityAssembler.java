package com.studentconnect.gouni.platform.carpooling.interfaces.rest.transform;

import com.studentconnect.gouni.platform.carpooling.domain.model.aggregates.Student;
import com.studentconnect.gouni.platform.carpooling.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student student) {
        return new StudentResource(
                student.getStudentRecordId(),
                student.getProfileId()
        );
    }
}
