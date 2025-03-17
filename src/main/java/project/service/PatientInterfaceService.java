package project.service;

import project.model.Patient;

import java.util.List;

public interface PatientInterfaceService {
    void createTablePatient();
    void addPatient(Patient patient, int doctorId);
    List<Patient> getPatients();
    List<Patient> getPatientsByGender(String gender);
}
