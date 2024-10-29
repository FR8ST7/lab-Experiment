package javaSWING;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    private JTextField idField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        JLabel idLabel = new JLabel("User ID:");
        idLabel.setBounds(50, 50, 100, 30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(150, 50, 200, 30);
        add(idField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 140, 100, 30);
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateUser();
            }
        });

        setVisible(true);
    }

    private void validateUser() {
        String userId = idField.getText();
        String password = new String(passwordField.getPassword());

        Connection connection = DBConnection.getConnection();
        try {
            // Validate user credentials
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ?");
            stmt.setString(1, userId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Login successful
                JOptionPane.showMessageDialog(this, "Login successful!");
                new RegisterPatient(); // Open the registration form
                dispose(); // Close the login form
            } else {
                // Invalid credentials
                JOptionPane.showMessageDialog(this, "Invalid ID or Password. Please try again.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
