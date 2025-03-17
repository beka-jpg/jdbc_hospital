package project.service;

import project.model.Doctor;

import java.util.List;

public interface DoctorInterfaceService {
    void createTableDoctor();
    void addDoctor(Doctor doctor, int hospitalId);
    void addDoctors(List<Doctor> doctors, int hospitalId);
    List<Doctor> getDoctorsByPosition(String position);
    Doctor getDoctorByName(String name);
    Doctor getDoctorsWhoHaveMoreFivePatients();
    void deleteDoctorById(int id);
    List<Doctor> getAllDoctors();
}
