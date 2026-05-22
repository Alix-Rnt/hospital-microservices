package com.adae.patientservice.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.adae.patientservice.entities.Patient;

@Service
public class PatientRepository {
    private final List<Patient> patients = new ArrayList<>();

    public void save(Patient patient) {
        patient.setId(UUID.randomUUID());
        patients.add(patient);
    }

    public List<Patient> findAll() {
        return patients;
    }

    public Optional<Patient> findById(UUID id) {
        return patients.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void delete(UUID id) {
        patients.removeIf(p -> p.getId().equals(id));
    }
}
