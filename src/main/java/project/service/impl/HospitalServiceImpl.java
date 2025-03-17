package project.service.impl;

import project.dao.HospitalInterfaceDao;
import project.dao.impl.HospitalDaoImpl;
import project.model.Hospital;
import project.service.HospitalInterfaceService;

public class HospitalServiceImpl implements HospitalInterfaceService {
    static HospitalInterfaceDao hospitalInterfaceDao = new HospitalDaoImpl();
    @Override
    public void createTableHospital() {
        hospitalInterfaceDao.createTableHospital();
    }

    @Override
    public void addHospital(Hospital hospital) {
        hospitalInterfaceDao.addHospital(hospital);
    }
}
