package com.adae.appointmentservice.controllers;

import java.io.IOException;
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

import com.adae.appointmentservice.entities.Appointment;
import com.adae.appointmentservice.services.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class appointmentController {
    private final AppointmentService appointmentService;

    public appointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Appointment> getappointments() {
        return appointmentService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getappointment(@PathVariable UUID id) {
        return appointmentService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createappointment(@RequestBody Appointment appointment) throws IOException, InterruptedException {
        appointmentService.save(appointment);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateappointment(@RequestBody Appointment appointment, @PathVariable UUID id) throws IOException, InterruptedException {
        appointmentService.update(id, appointment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteappointment(@PathVariable UUID id) {
        appointmentService.delete(id);
    }
}
