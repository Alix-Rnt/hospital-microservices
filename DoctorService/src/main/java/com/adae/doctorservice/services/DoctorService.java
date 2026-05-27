package com.adae.doctorservice.services;

import java.util.List;
import java.util.UUID;

import com.adae.doctorservice.entities.Doctor;

public interface DoctorService {
    List<Doctor> getAll();
    Doctor get(UUID id);
    void save(Doctor doctor);
    void update(UUID id, Doctor doctor);
    void delete(UUID id);
}
