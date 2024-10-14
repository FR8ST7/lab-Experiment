package oopsproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientRegistrationForm extends JFrame {
    private JTextField nameField;
    private JTextField addressField;
    private JTextField phoneField;
    private JButton registerButton;

    public PatientRegistrationForm() {
        setTitle("Patient Registration");
        setLayout(null);
        setSize(400, 300);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 25);
        add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 70, 100, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(150, 70, 200, 25);
        add(addressField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 110, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 110, 200, 25);
        add(phoneField);

        registerButton = new JButton("Register");
        registerButton.setBounds(150, 160, 100, 30);
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();

                // Create Patient object and store in database
                patient patient = new patient(0, name, address, phone); // Assuming auto-increment for ID
                try {
                    new PatientDAO().addPatient(patient);
                    JOptionPane.showMessageDialog(null, "Patient registered successfully!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PatientRegistrationForm();
    }
}
