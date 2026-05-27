package com.adae.patientservice.entities;

import java.time.LocalDate;
import java.util.UUID;

/*
 * A Patient is an entity with atributes : 
 * - id          : UUID      eg. "123456"
 * - firstName   : String    eg. "Jean"
 * - lastName    : String    eg. "Dupont"
 * - birthdate   : LocalDate eg. "2007-12-03"
 * - phoneNumber : String    eg. "1-789-123-456"
 * - email       : String    eg. "jean.dupont@email.com"
 */
public class Patient {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String phoneNumber;
    private String email;

    public Patient() {}

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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}