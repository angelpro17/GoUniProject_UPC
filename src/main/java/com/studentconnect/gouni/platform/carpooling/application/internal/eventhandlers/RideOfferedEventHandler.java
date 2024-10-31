package com.studentconnect.gouni.platform.carpooling.application.internal.eventhandlers;


import org.springframework.stereotype.Service;
import com.studentconnect.gouni.platform.carpooling.domain.services.StudentCommandService;

@Service
public class RideOfferedEventHandler {
    private final StudentCommandService studentCommandService;

    public RideOfferedEventHandler(StudentCommandService studentCommandService) {
        this.studentCommandService = studentCommandService;
    }


}
