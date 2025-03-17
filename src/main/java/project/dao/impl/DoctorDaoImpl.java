package project.dao.impl;

import project.config.JdbcConfig;
import project.dao.DoctorInterfaceDao;
import project.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorInterfaceDao {
    Connection connection;


    @Override
    public void createTableDoctor() {
        String sql = """
                CREATE TABLE IF NOT EXISTS doctor(
                    doctor_id SERIAL PRIMARY KEY,
                    name VARCHAR(50),
                    position VARCHAR(50),
                    experience INTEGER NOT NULL,
                    hospital_id INTEGER  REFERENCES hospital(hospital_id)
                )
                """;
        connection = JdbcConfig.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            statement.close();
            System.out.println("Table doctor created");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addDoctor(Doctor doctor, int hospitalId) {
        String sql = """
                INSERT INTO doctor (name, position, experience, hospital_id) values(?,?,?,?);
                """;
        Connection connection = JdbcConfig.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getPosition());
            preparedStatement.setInt(3, doctor.getExperience());
            preparedStatement.setInt(4,hospitalId);
            preparedStatement.executeUpdate();
        } catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addDoctors(List<Doctor> doctors, int hospitalId) {

        String sql = "INSERT INTO doctor (name, position, experience, hospital_id) VALUES (?, ?, ?, ?);";

        try (Connection connection = JdbcConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (Doctor doctor : doctors) {
                preparedStatement.setString(1, doctor.getName());
                preparedStatement.setString(2, doctor.getPosition());
                preparedStatement.setInt(3, doctor.getExperience());
                preparedStatement.setInt(4, hospitalId);
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            System.out.println("Все врачи успешно добавлены!");

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении врачей: " + e.getMessage());
        }
    }

    @Override
    public Doctor getDoctorHaveMoreFivePatients() {
        String sql = "select d.doctor_id, d.name, d.position, COUNT(p.patient_id)  as patient_count " +
                "from doctor d " +
                "join patient p on d.doctor_id = p.doctor_id " +
                "group by d.doctor_id, d.name, d.position" +
                " HAVING COUNT(p.patient_id) > 5";
        connection = JdbcConfig.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("doctor_id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setPosition(resultSet.getString("position"));
                doctor.setExperience(resultSet.getInt("patient_count"));
                return doctor;
            }
        } catch (SQLException e ){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void deleteDoctorById(int doctorId) {
        String sql = "DELETE from doctor where doctor_id = ?";
        connection = JdbcConfig.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, doctorId);
            preparedStatement.executeUpdate();
            System.out.println("Doctor deleted");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        String sql = "SELECT * from doctor";
        List<Doctor> doctors = new ArrayList<>();

        connection = JdbcConfig.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("doctor_id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setPosition(resultSet.getString("position"));
                doctor.setExperience(resultSet.getInt("experience"));
                doctors.add(doctor);
            }
            return doctors;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Doctor> getDoctorsByPosition(String position) {
        String sql = "SELECT * from doctor where position = ?;";
        List<Doctor> doctors = new ArrayList<>();

        connection = JdbcConfig.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, position);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("doctor_id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setPosition(resultSet.getString("position"));
                doctor.setExperience(resultSet.getInt("experience"));
                doctors.add(doctor);
            }

            return doctors;
        } catch (SQLException e ){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Doctor getDoctorByName(String name) {
        String sql = "select * from doctor where name = ?";
        connection = JdbcConfig.getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("doctor_id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setPosition(resultSet.getString("position"));
                doctor.setExperience(resultSet.getInt("experience"));
                return doctor;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
