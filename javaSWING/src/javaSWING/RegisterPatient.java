package javaSWING;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterPatient extends JFrame {
    private JTextField nameField, phoneField, addressField;

    public RegisterPatient() {
        setTitle("Patient Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 30);
        add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 100, 100, 30);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 100, 200, 30);
        add(phoneField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 150, 100, 30);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(150, 150, 200, 30);
        add(addressField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 200, 100, 30);
        
        registerButton.setBackground(Color.BLUE);
        registerButton.setForeground(Color.WHITE);
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerPatient();
            }
        });

        setVisible(true);
    }

    private void registerPatient() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        Connection connection = DBConnection.getConnection();
        try {
            // Insert patient into the 'patients' table with registration date
            PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO patients (name, phone, address, registration_date) VALUES (?, ?, ?, CURRENT_TIMESTAMP)", 
                PreparedStatement.RETURN_GENERATED_KEYS
            );
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, address);
            stmt.executeUpdate();

            // Get the generated patient ID
            ResultSet rs = stmt.getGeneratedKeys();
            int patientId = 0;
            if (rs.next()) {
                patientId = rs.getInt(1);
            }

            JOptionPane.showMessageDialog(this, "Patient registered successfully!");

            // After successful registration, open the PrescriptionForm with the patient ID
            new PrescriptionForm(patientId); // Make sure the PrescriptionForm constructor takes patientId
            dispose(); // Close the registration form
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new RegisterPatient();
    }
}