echo Build PatientService
call mvn package -DskipTests -f PatientService/pom.xml

echo Build DoctorService
call mvn package -DskipTests -f DoctorService/pom.xml

echo Build AppointmentService
call mvn package -DskipTests -f AppointmentService/pom.xml

@REM echo Launch Docker
@REM docker-compose up --build