package project.dao;

import project.model.Doctor;
import project.model.Hospital;

import java.util.List;

public interface HospitalInterfaceDao {
    void createTableHospital();
    void addHospital(Hospital hospital);
//    void updateHospital(Hospital hospital);
    Hospital getHospital(int hospitalId);
    void deleteHospital(int hospitalId);
}
