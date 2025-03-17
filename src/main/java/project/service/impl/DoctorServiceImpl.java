package project.service.impl;

import project.dao.DoctorInterfaceDao;
import project.dao.impl.DoctorDaoImpl;
import project.model.Doctor;
import project.service.DoctorInterfaceService;

import java.util.List;

public class DoctorServiceImpl implements DoctorInterfaceService {
    static DoctorInterfaceDao doctorInterfaceDao = new DoctorDaoImpl();
    @Override
    public void createTableDoctor() {
        doctorInterfaceDao.createTableDoctor();
    }

    @Override
    public void addDoctor(Doctor doctor, int hospitalId) {
        doctorInterfaceDao.addDoctor(doctor, hospitalId);
    }

    @Override
    public void addDoctors(List<Doctor> doctors, int hospitalId) {
        doctorInterfaceDao.addDoctors(doctors, hospitalId);
    }

    @Override
    public List<Doctor> getDoctorsByPosition(String position) {
        return doctorInterfaceDao.getDoctorsByPosition(position);
    }

    @Override
    public Doctor getDoctorByName(String name) {
        return doctorInterfaceDao.getDoctorByName(name);
    }

    @Override
    public Doctor getDoctorsWhoHaveMoreFivePatients() {
        return doctorInterfaceDao.getDoctorHaveMoreFivePatients();
    }

    @Override
    public void deleteDoctorById(int id) {
        doctorInterfaceDao.deleteDoctorById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorInterfaceDao.getAllDoctors();
    }

}
