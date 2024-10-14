package oopsproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {

    public void addPatient(patient Patient) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "INSERT INTO patients (id, name, address, phone) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, Patient.getPatientId());
        statement.setString(2, Patient.getName());
        statement.setString(3, Patient.getAddress());
        statement.setString(4, Patient.getPhoneNumber());
        statement.executeUpdate();
    }

    public void getPatientById(int patientId) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM patients WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, patientId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            System.out.println("Patient Details: " + name + ", " + address + ", " + phone);
        } else {
            System.out.println("No patient found with ID " + patientId);
        }
    }
}
