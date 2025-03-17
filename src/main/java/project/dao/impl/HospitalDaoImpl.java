package project.dao.impl;

import project.config.JdbcConfig;
import project.dao.HospitalInterfaceDao;
import project.model.Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class HospitalDaoImpl implements HospitalInterfaceDao {
    Connection connection;
    @Override
    public void createTableHospital() {
        String sql = """
                CREATE TABLE IF NOT EXISTS hospital (
                hospital_id SERIAL PRIMARY KEY,
                name VARCHAR(50),
                address VARCHAR(50)
                )
                """;
        connection = JdbcConfig.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            statement.close();
            System.out.println("Hospital table created");
        } catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addHospital(Hospital hospital) {
        String sql = "INSERT INTO hospital(name,address) VALUES(?,?)";
        connection = JdbcConfig.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, hospital.getName());
            statement.setString(2, hospital.getAddress());
            statement.executeUpdate();
        } catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Hospital getHospital(int hospitalId) {
        return null;
    }

    @Override
    public void deleteHospital(int hospitalId) {

    }
}
