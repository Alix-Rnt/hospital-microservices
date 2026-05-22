package com.adae.patientservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.adae.patientservice.entities.Patient;
import com.adae.patientservice.exceptions.PatientNotFoundException;
import com.adae.patientservice.repositories.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;

    public PatientServiceImpl (PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient get(UUID id) {
        return patientRepository.
                    findById(id).
                    orElseThrow( () -> new PatientNotFoundException("Patient with id " + id + " not found"));
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void update(UUID id, Patient patient) {
        Patient originPatient = this.get(id);
        originPatient.setFirstName(patient.getFirstName());
        originPatient.setLastName(patient.getLastName());
        originPatient.setBirthdate(patient.getBirthdate());
        originPatient.setPhoneNumber(patient.getPhoneNumber());
        originPatient.setEmail(patient.getEmail());

        patientRepository.save(originPatient);
    }

    @Override
    public void delete(UUID id) {
        patientRepository.delete(id);
    }
    
}
