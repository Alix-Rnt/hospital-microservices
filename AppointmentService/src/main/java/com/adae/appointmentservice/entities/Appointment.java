package com.adae.appointmentservice.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.adae.appointmentservice.status.AppointmentStatus;

/*
 * A Doctor is an entity with atributes : 
 * - id        : UUID              eg. "123456"
 * - patientId : UUID              eg. "789123"
 * - doctorId  : UUID              eg. "456789"
 * - dateTime  : LocalDateTime     eg. "2007-12-03T10:15:30"
 * - reason    : String            eg. "Bad flu"
 * - status    : AppointmentStatus eg. SCHEDULED
 */
public class Appointment {
    private UUID id;
    private UUID patientId;
    private UUID doctorId;
    private LocalDateTime dateTime;
    private String reason;
    private AppointmentStatus status;

    public Appointment(UUID id, LocalDateTime dateTime, UUID doctorId, UUID patientId, String reason, AppointmentStatus status) {
        this.dateTime = dateTime;
        this.doctorId = doctorId;
        this.id = id;
        this.patientId = patientId;
        this.reason = reason;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
