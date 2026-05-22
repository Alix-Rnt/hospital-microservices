package com.adae.appointmentservice.services;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.adae.appointmentservice.entities.Appointment;

public interface AppointmentService {
    List<Appointment> getAll();
    Appointment get(UUID id);
    void save(Appointment appointment) throws IOException, InterruptedException;
    void update(UUID id, Appointment appointment) throws IOException, InterruptedException;
    void delete(UUID id);
}
