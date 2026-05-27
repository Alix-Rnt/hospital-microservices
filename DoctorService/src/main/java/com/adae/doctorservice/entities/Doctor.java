package com.adae.doctorservice.entities;

import java.util.UUID;

/*
 * A Doctor is an entity with atributes : 
 * - id          : UUID   eg. "123456"
 * - firstName   : String eg. "Marie"
 * - lastName    : String eg. "Tremblay"
 * - speciality  : String eg. "Cardiology"
 */
public class Doctor {
    private UUID id;
    private String firstName;
    private String lastName;
    private String speciality;

    public Doctor() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
