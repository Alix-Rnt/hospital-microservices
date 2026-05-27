package com.adae.doctorservice.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.adae.doctorservice.entities.Doctor;

@Service
public class DoctorRepository {
    private final List<Doctor> doctors = new ArrayList<>();

    public void save(Doctor doctor) {
        doctor.setId(UUID.randomUUID());
        doctors.add(doctor);
    }

    public List<Doctor> findAll() {
        return doctors;
    }

    public Optional<Doctor> findById(UUID id) {
        return doctors.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void delete(UUID id) {
        doctors.removeIf(p -> p.getId().equals(id));
    }
}
