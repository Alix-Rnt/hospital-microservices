# hospital-microservices

A Microservices-based application simulating a hospital basic activity.

## Technologies

- Java 21
- Maven
- Docker
- Spring Boot

### VSCode recommended extensions

- Docker
- REST Client

## How to use

1. Build the services with Maven using `build.bat` or by simply using the `mvn package` lifecycle command.
2. Launch the services with Docker with `docker-compose up --build` or via the `docker-compose.yml` file or directly using the Docker app.
3. Send requests via the `test.http` file to test it all.

PatientService, DoctorService and AppointmentService start on localhost ports 8081, 8082 and 8083 respectively.

## Functional services

The three services are independently deployable applications, still AppointmentService depends PatientService and DoctorService to run.

### Patient Service

Contains the general logic of working and validating patient.

| HTTP METHOD | PATH                 | USAGE                  |
|-------------|----------------------|------------------------|
| GET         | /api/patients        | Get all patients       |
| GET         | /api/patients/{UUID} | Get patient by uuid    |
| POST        | /api/patients        | Create new patient     |
| PUT         | /api/patients/{UUID} | Change patient info    |
| DELETE      | /api/patients/{UUID} | Delete patient by uuid |

**Sample JSON for Patient Service**

**Create a Patient :**

```json
{
    "firstName": "Jean",
    "lastName": "Dupont",
    "birthdate": "1990-05-15",
    "phoneNumber": "514-123-4567",
    "email": "jean.dupont@email.com"
}
```

### Doctor Service

Contains the general logic of working and validating doctor.

| HTTP METHOD | PATH                | USAGE                 |
|-------------|---------------------|-----------------------|
| GET         | /api/doctors        | Get all doctors       |
| GET         | /api/doctors/{UUID} | Get doctor by uuid    |
| POST        | /api/doctors        | Create new doctor     |
| PUT         | /api/doctors/{UUID} | Change doctor info    |
| DELETE      | /api/doctors/{UUID} | Delete doctor by uuid |

**Sample JSON for doctor Service**

**Create a doctor :**

```json
{
    "firstName": "Marie",
    "lastName": "Tremblay",
    "specialty": "Cardiology"
}
```

### Appointment Service

Contains the general logic of working and validating appointment.

| HTTP METHOD | PATH                     | USAGE                      |
|-------------|--------------------------|----------------------------|
| GET         | /api/appointments        | Get all appointments       |
| GET         | /api/appointments/{UUID} | Get appointment by uuid    |
| POST        | /api/appointments        | Create new appointment     |
| PUT         | /api/appointments/{UUID} | Change appointment info    |
| DELETE      | /api/appointments/{UUID} | Delete appointment by uuid |

**Sample JSON for doctor Service**

**Create a doctor :**

```json
{
    "patientId": "{PATIENT_UUID}",
    "doctorId": "{DOCTOR_UUID}",
    "dateTime": "2026-06-01T10:00:00",
    "reason": "General consultation",
    "status": "SCHEDULED"
}
```
