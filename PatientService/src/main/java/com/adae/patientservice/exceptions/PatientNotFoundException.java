package com.adae.patientservice.exceptions;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String message)
    {
        super(message);
    }
}
