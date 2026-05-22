package com.adae.patientservice.services;

import java.util.List;
import java.util.UUID;

import com.adae.patientservice.entities.Patient;

public interface PatientService {
    List<Patient> getAll();
    Patient get(UUID id);
    void save(Patient patient);
    void update(UUID id, Patient patient);
    void delete(UUID id);
}
