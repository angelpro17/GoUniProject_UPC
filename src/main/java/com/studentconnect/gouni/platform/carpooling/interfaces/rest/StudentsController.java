package com.studentconnect.gouni.platform.carpooling.interfaces.rest;

import com.studentconnect.gouni.platform.carpooling.domain.model.queries.GetStudentByUniRiderStudentRecordIdQuery;
import com.studentconnect.gouni.platform.carpooling.domain.model.valueobjects.UniRiderStudentRecordId;
import com.studentconnect.gouni.platform.carpooling.domain.services.StudentCommandService;
import com.studentconnect.gouni.platform.carpooling.domain.services.StudentQueryService;
import com.studentconnect.gouni.platform.carpooling.interfaces.rest.resources.CreateStudentResource;
import com.studentconnect.gouni.platform.carpooling.interfaces.rest.resources.StudentResource;
import com.studentconnect.gouni.platform.carpooling.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import com.studentconnect.gouni.platform.carpooling.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Students", description = "Student Management Endpoints")
public class StudentsController {
    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;


    public StudentsController(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var studentId = studentCommandService.handle(createStudentCommand);
        if (studentId.studentRecordId().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getStudentByAcmeStudentRecordIdQuery = new GetStudentByUniRiderStudentRecordIdQuery(studentId);
        var student = studentQueryService.handle(getStudentByAcmeStudentRecordIdQuery);
        if (student.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);

    }

    /**
     * GET /api/v1/students/{studentRecordId}
     *
     * <p>Endpoint that gets a student by its acme student record id</p>
     *
     * @param studentRecordId the acme student record id
     * @return the student resource
     * @see StudentResource
     */
    @GetMapping("/{studentRecordId}")
    public ResponseEntity<StudentResource> getStudentByUniRiderStudentRecordId(@PathVariable String studentRecordId) {
        var acmeStudentRecordId = new UniRiderStudentRecordId(studentRecordId);
        var getStudentByUniRiderStudentRecordIdQuery = new GetStudentByUniRiderStudentRecordIdQuery(acmeStudentRecordId);
        var student = studentQueryService.handle(getStudentByUniRiderStudentRecordIdQuery);
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return ResponseEntity.ok(studentResource);
    }
}
