package project.dao.impl;


import project.config.JdbcConfig;
import project.dao.PatientInterfaceDao;
import project.model.GENDER;
import project.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientInterfaceDao {
    Connection connection;
    @Override
    public void createTablePatient() {
        String sql = """
                CREATE TABLE IF NOT EXISTS PATIENT (
                    patient_id SERIAL PRIMARY KEY,
                    name VARCHAR(255),
                    age INTEGER,
                    gender gender,
                    diagnosed VARCHAR(255),
                    doctor_id INTEGER REFERENCES doctor(doctor_id)
                )
                """;
        connection = JdbcConfig.getConnection();
        try(Statement statement = connection.createStatement()) {
            statement.execute(sql);
            statement.close();
            System.out.println("Patient table created");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addPatient(Patient patient, int doctorId) {
        String sql = """
                INSERT INTO patient(name,age,gender,diagnosed,doctor_id) values(?,?,?,?,?)
                """;
        connection = JdbcConfig.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getGender().toString());
            statement.setString(4, patient.getDiagnose());
            statement.setInt(5, doctorId);
            statement.execute();
            connection.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updatePatient(Patient patient) {

    }

    @Override
    public Patient getPatient(int patientId) {
        return null;
    }

    @Override
    public void deletePatient(int patientId) {

    }

    @Override
    public List<Patient> getPatients() {
        String sql = "SELECT * FROM patient";
        List<Patient> patients = new ArrayList<>();

        try (Connection connection = JdbcConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setId(resultSet.getInt("patient_id"));
                patient.setName(resultSet.getString("name"));
                patient.setAge(resultSet.getInt("age"));
                patient.setGender(GENDER.valueOf(resultSet.getString("gender").toUpperCase()));
                patient.setDiagnose(resultSet.getString("diagnosed")); // исправил ошибку в названии
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    @Override
    public List<Patient> getPatientsByGender(String gender) {
        String sql = "SELECT * FROM patient where gender = ?";
        List<Patient> patients = new ArrayList<>();
        connection = JdbcConfig.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,gender.toUpperCase());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setId(resultSet.getInt("patient_id"));
                patient.setName(resultSet.getString("name"));
                patient.setAge(resultSet.getInt("age"));
                patient.setGender(GENDER.valueOf(resultSet.getString("gender").toUpperCase()));
                patient.setDiagnose(resultSet.getString("diagnosed"));
                patients.add(patient);
            }
            return patients;
        } catch (SQLException e ){
            e.printStackTrace();
        }
        return null;
    }
}
