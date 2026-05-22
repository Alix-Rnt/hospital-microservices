package com.adae.appointmentservice.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.adae.appointmentservice.entities.Appointment;

public class AppointmentRepository {
    private final List<Appointment> appointments = new ArrayList<>();

    public void save(Appointment appointment) {
        appointment.setId(UUID.randomUUID());
        appointments.add(appointment);
    }

    public List<Appointment> findAll() {
        return appointments;
    }

    public Optional<Appointment> findById(UUID id) {
        return appointments.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void delete(UUID id) {
        appointments.removeIf(p -> p.getId().equals(id));
    }
}
