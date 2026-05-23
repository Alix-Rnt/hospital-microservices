package com.adae.appointmentservice.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import com.adae.appointmentservice.entities.Appointment;
import com.adae.appointmentservice.exceptions.AppointmentNotFoundException;
import com.adae.appointmentservice.exceptions.DoctorNotFoundException;
import com.adae.appointmentservice.exceptions.PatientNotFoundException;
import com.adae.appointmentservice.repositories.AppointmentRepository;

public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Value("${patient.service.url}")
    private String patientServiceUrl;

    @Value("${doctor.service.url}")
    private String doctorServiceUrl;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment get(UUID id) {
        return appointmentRepository.
                        findById(id).
                        orElseThrow( () -> new AppointmentNotFoundException(id));
    }

    @Override
    public void save(Appointment appointment) throws IOException, InterruptedException {
        validatePatient(appointment);
        validateDoctor(appointment);
        appointmentRepository.save(appointment);
    }

    @Override
    public void update(UUID id, Appointment appointment) throws IOException, InterruptedException {
        Appointment originAppointment = this.get(id);
        validatePatient(appointment);
        validateDoctor(appointment);

        originAppointment.setDateTime(appointment.getDateTime());
        originAppointment.setDoctorId(appointment.getDoctorId());
        originAppointment.setPatientId(appointment.getPatientId());
        originAppointment.setReason(appointment.getReason());
        originAppointment.setStatus(appointment.getStatus());

        appointmentRepository.save(originAppointment);
    }

    @Override
    public void delete(UUID id) {
        appointmentRepository.
                findById(id).
                orElseThrow( () -> new AppointmentNotFoundException(id));
        appointmentRepository.delete(id);
    }

    private void validatePatient(Appointment appointment) throws IOException, InterruptedException {
        UUID id = appointment.getPatientId();
        HttpRequest patientRequest = HttpRequest.newBuilder()
            .uri(URI.create(patientServiceUrl + "/api/patients/" + id))
            .GET()
            .build();
        if (httpClient.send(patientRequest, HttpResponse.BodyHandlers.ofString()).statusCode() == 404) {
            throw new PatientNotFoundException(id);
        }
    }

    private void validateDoctor(Appointment appointment) throws IOException, InterruptedException {
        UUID id = appointment.getDoctorId();
        HttpRequest doctorRequest = HttpRequest.newBuilder()
            .uri(URI.create(doctorServiceUrl + "/api/patients/" + id))
            .GET()
            .build();
        if (httpClient.send(doctorRequest, HttpResponse.BodyHandlers.ofString()).statusCode() == 404) {
            throw new DoctorNotFoundException(id);
        }
    }

}
