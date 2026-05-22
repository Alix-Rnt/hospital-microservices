package com.adae.appointmentservice.exceptions;

import java.util.UUID;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
    
    public PatientNotFoundException(UUID id) {
        super("Patient with id " + id + " not found");
    }
}
