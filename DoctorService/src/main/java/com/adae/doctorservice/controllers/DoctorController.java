package com.adae.doctorservice.controllers;

import java.util.Collection;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adae.doctorservice.entities.Doctor;
import com.adae.doctorservice.services.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Doctor> getDoctors() {
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctor(@PathVariable UUID id) {
        return doctorService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDoctor(@RequestBody Doctor doctor) {
        doctorService.save(doctor);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateDoctor(@RequestBody Doctor doctor, @PathVariable UUID id) {
        doctorService.update(id, doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable UUID id) {
        doctorService.delete(id);
    }
}
