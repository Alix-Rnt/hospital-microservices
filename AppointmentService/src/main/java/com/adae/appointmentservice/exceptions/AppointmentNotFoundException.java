package com.adae.appointmentservice.exceptions;

import java.util.UUID;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String message) {
        super(message);
    }
    
    public AppointmentNotFoundException(UUID id) {
        super("Appointment with id " + id + " not found");
    }
}
