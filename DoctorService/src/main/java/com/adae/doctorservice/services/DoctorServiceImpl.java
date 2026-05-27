package com.adae.doctorservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.adae.doctorservice.entities.Doctor;
import com.adae.doctorservice.exceptions.DoctorNotFoundException;
import com.adae.doctorservice.repositories.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    
    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor get(UUID id) {
        return doctorRepository.
                    findById(id).
                    orElseThrow( () -> new DoctorNotFoundException(id));
    }

    @Override
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void update(UUID id, Doctor doctor) {
        Doctor originDoctor = this.get(id);

        originDoctor.setFirstName(doctor.getFirstName());
        originDoctor.setLastName(doctor.getLastName());
        originDoctor.setSpeciality(doctor.getSpeciality());

        doctorRepository.save(originDoctor);
    }

    @Override
    public void delete(UUID id) {
        doctorRepository.
            findById(id).
            orElseThrow( () -> new DoctorNotFoundException(id));
        doctorRepository.delete(id);
    }
}
