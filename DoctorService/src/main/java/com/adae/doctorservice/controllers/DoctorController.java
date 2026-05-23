package com.adae.doctorservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adae.doctorservice.services.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @SuppressWarnings("unused") // sould be removed
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    /* Implement controller methods */
}
