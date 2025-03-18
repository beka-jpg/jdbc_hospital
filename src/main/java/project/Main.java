package project;

import project.dao.DoctorInterfaceDao;
import project.dao.HospitalInterfaceDao;
import project.dao.PatientInterfaceDao;
import project.dao.impl.DoctorDaoImpl;
import project.dao.impl.HospitalDaoImpl;
import project.dao.impl.PatientDaoImpl;
import project.model.Doctor;
import project.model.GENDER;
import project.model.Patient;
import project.service.DoctorInterfaceService;
import project.service.HospitalInterfaceService;
import project.service.PatientInterfaceService;
import project.service.impl.DoctorServiceImpl;
import project.service.impl.HospitalServiceImpl;
import project.service.impl.PatientServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static HospitalInterfaceDao hospitalInterfaceDao = new HospitalDaoImpl();
    static DoctorInterfaceDao doctorInterfaceDao = new DoctorDaoImpl();
    static PatientInterfaceDao patientInterfaceDao = new PatientDaoImpl();


    static HospitalInterfaceService hospitalInterfaceService =  new HospitalServiceImpl();
    static DoctorInterfaceService doctorInterfaceService =  new DoctorServiceImpl();
    static PatientInterfaceService patientInterfaceService =  new PatientServiceImpl();

    public static void main(String[] args) {
//        hospitalInterfaceService.createTableHospital();
//        doctorInterfaceService.createTableDoctor();
//        patientInterfaceService.createTablePatient();

//        hospitalInterfaceDao.addHospital(
//                new Hospital("hospital", "Lenin no 55", new ArrayList<>())
//        );


//        doctorInterfaceService.addDoctor(new Doctor(
//                "Doctor1",
//                "surgeon",
//                4
//        ));
//
//        patientInterfaceService.addPatient(new Patient(
//            "Patient1",
//                43,
//                GENDER.MALE,
//                "diagnose one something about it"
//        ), 1 );


//        List<Doctor> doctors = List.of(
//                new Doctor("Иван Иванов", "Хирург", 10),
//                new Doctor("Анна Смирнова", "Терапевт", 7),
//                new Doctor("Сергей Козлов", "Педиатр", 5)
//        );
//
//        doctorInterfaceDao.addDoctors(doctors, 1);

//        System.out.println(doctorInterfaceDao.getDoctorByName("Doctor1"));/


//        List<Patient> patients = List.of(
//                new Patient("Иван Петров", 35, GENDER.MALE, "Грипп"),
//                new Patient("Анна Смирнова", 28, GENDER.FEMALE, "Ангина"),
//                new Patient("Сергей Козлов", 40, GENDER.MALE, "Пневмония"),
//                new Patient("Мария Васильева", 50, GENDER.FEMALE, "Гипертония"),
//                new Patient("Дмитрий Федоров", 22, GENDER.MALE, "Перелом руки"),
//                new Patient("Екатерина Сидорова", 31, GENDER.FEMALE, "Аллергия")
//        );
//
//
//        for (Patient patient : patients) {
//            patientInterfaceService.addPatient(patient,2);
//        }

//        System.out.println(doctorInterfaceDao.getDoctorHaveMoreFivePatients());
//        doctorInterfaceDao.deleteDoctorById(3);

//        System.out.println(patientInterfaceDao.getPatients());
//        System.out.println(patientInterfaceDao.getPatientsByGender("male"));


//        System.out.println(doctorInterfaceDao.getAllDoctors());

        try {
            doctorInterfaceService.createTableDoctor();
            patientInterfaceService.createTablePatient();
            hospitalInterfaceService.createTableHospital();


            boolean isTrue = true;

            while (isTrue) {
                System.out.println("""
                        1.Создать доктора
                        2.Создать пациента
                        3.Получить докторов по специальности
                        4.Получить доктора по имени
                        5.Получить докторов у которых больше 5 пациентов
                        6.Удалить доктора по айди
                        7.Получить всех пациентов
                        8.Получить пациентов по полу
                        """);

                Scanner scanner = new Scanner(System.in);
                int chose = scanner.nextInt();

                switch (chose) {
                    case 1:

                        System.out.println("Enter a name");
                        scanner.nextLine();
                        String docName = scanner.nextLine();



                        System.out.println("Enter a experience");
                        int experience = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter a position");
                        String docPosition = scanner.nextLine();

                        Doctor doctor = new Doctor(docName, docPosition, experience);


                        doctorInterfaceService.addDoctor(doctor, 1);


                        break;
                    case 2:
                        System.out.println("Enter a name");
                        scanner.nextLine();
                        String name = scanner.nextLine();


                        System.out.println("Enter a gender");
                        String gender = scanner.nextLine();

                        System.out.println("Enter a age");
                        int age = scanner.nextInt();

                        Patient patient = new Patient(name, age);

                        if (gender.equals("male")) {
                            patient.setGender(GENDER.MALE);
                        } else {
                            patient.setGender(GENDER.FEMALE);
                        }



                        List<Doctor> doctors = doctorInterfaceService.getAllDoctors();
                        Random random = new Random();
                        int r = random.nextInt(doctors.size());

                        patientInterfaceService.addPatient(patient, r);


                        break;
                    case 3:
                        System.out.println("Enter a position");
                        scanner.nextLine();
                        String position = scanner.nextLine();
                        System.out.println(doctorInterfaceService.getDoctorsByPosition(position));
                        break;
                    case 4:

                        System.out.println("Enter a name");
                        scanner.nextLine();
                        String nameFind = scanner.nextLine();

                        System.out.println(doctorInterfaceService.getDoctorByName(nameFind));
                        break;
                    case 5:
                        System.out.println(doctorInterfaceService.getDoctorsWhoHaveMoreFivePatients());
                        break;
                    case 6:
                        System.out.println("Enter doctor id");
                        int id = scanner.nextInt();
                        doctorInterfaceService.deleteDoctorById(id);
                        break;
                    case 7:
                        System.out.println(patientInterfaceService.getPatients());
                        break;
                    case 8:

                        System.out.println("Enter a gender");
                        scanner.nextLine();
                        String genderChose = scanner.nextLine();
                        System.out.println(genderChose);
                        System.out.println(
                                patientInterfaceService.getPatientsByGender(genderChose));
                        break;
                }

            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
