package com.adae.appointmentservice.exceptions;

import java.util.UUID;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String message) {
        super(message);
    }
    
    public DoctorNotFoundException(UUID id) {
        super("Doctor with id " + id + " not found");
    }
}
