package project.dao;

import project.model.Doctor;

import java.util.List;

public interface DoctorInterfaceDao {
    void createTableDoctor();
    void addDoctor(Doctor doctor, int hospitalId);
    void addDoctors(List<Doctor> doctors, int hospitalId);
    Doctor getDoctorHaveMoreFivePatients();
//    void updateDoctor(Doctor doctor);
    void deleteDoctorById(int doctorId);
    Doctor getDoctorById(int doctorId);
    List<Doctor> getAllDoctors();

    List<Doctor> getDoctorsByPosition(String position);
    Doctor getDoctorByName(String name);
}
