package project.service.impl;

import project.dao.PatientInterfaceDao;
import project.dao.impl.PatientDaoImpl;
import project.model.Patient;
import project.service.PatientInterfaceService;

import java.util.List;

public class PatientServiceImpl implements PatientInterfaceService {
    static PatientInterfaceDao patientInterfaceDao = new PatientDaoImpl();
    @Override
    public void createTablePatient() {
        patientInterfaceDao.createTablePatient();
    }

    @Override
    public void addPatient(Patient patient, int doctorId) {
        patientInterfaceDao.addPatient(patient, doctorId);
    }

    @Override
    public List<Patient> getPatients() {
        return patientInterfaceDao.getPatients();
    }

    @Override
    public List<Patient> getPatientsByGender(String gender) {
        return patientInterfaceDao.getPatientsByGender(gender);
    }
}
