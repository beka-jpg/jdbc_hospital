package project.dao;

import project.model.Patient;

import java.util.List;

public interface PatientInterfaceDao {
    void createTablePatient();
    void addPatient(Patient patient, int doctorId);
    void updatePatient(Patient patient);
    Patient getPatient(int patientId);
    void deletePatient(int patientId);
    List<Patient> getPatients();
    List<Patient> getPatientsByGender(String gender);
}
