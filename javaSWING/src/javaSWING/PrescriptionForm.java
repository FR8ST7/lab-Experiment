package javaSWING;

import javax.swing.*;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrescriptionForm extends JFrame {
    private JTextField problemField;
    private JTextArea prescriptionArea;
    private int patientId;

    // Modify constructor to accept patientId
    public PrescriptionForm(int patientId) {
        this.patientId = patientId; // Store the patient ID
        
        setTitle("Prescription");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel problemLabel = new JLabel("Problem:");
        problemLabel.setBounds(50, 50, 100, 30);
        add(problemLabel);

        problemField = new JTextField();
        problemField.setBounds(150, 50, 200, 30);
        add(problemField);

        JButton generateButton = new JButton("Generate Prescription");
        generateButton.setBounds(150, 100, 200, 30);
        
        generateButton.setBackground(Color.BLUE);
        generateButton.setForeground(Color.WHITE);
        
        add(generateButton);

        prescriptionArea = new JTextArea();
        prescriptionArea.setBounds(50, 150, 300, 100);
        add(prescriptionArea);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatePrescription();
            }
        });

        setVisible(true);
    }

    private void generatePrescription() {
        String problem = problemField.getText();
        String medicine = "";
        String dosage = "2 times a day for 5 days";  // Default dosage

        // Prescribe based on problem
        switch (problem.toLowerCase()) {
            case "fever":
                medicine = "Paracetamol";
                dosage = "500 mg every 6 hours for 3 days";
                break;
            case "cold":
                medicine = "Cetirizine";
                dosage = "10 mg once daily for 5 days";
                break;
            // Add more cases as needed
            case "headache":
                medicine = "Ibuprofen";
                dosage = "400 mg every 4-6 hours as needed";
                break;
            case "stomachache":
                medicine = "Omeprazole";
                dosage = "20 mg once daily before meals for 7 days";
                break;
            case "cough":
                medicine = "Cough Syrup (Dextromethorphan)";
                dosage = "10 ml every 4 hours";
                break;
            case "diarrhea":
                medicine = "Loperamide";
                dosage = "2 mg after each loose stool, max 16 mg/day";
                break;
            case "sore throat":
                medicine = "Lozenges (Amylmetacresol)";
                dosage = "One lozenge every 2-3 hours";
                break;
            case "allergy":
                medicine = "Loratadine";
                dosage = "10 mg once daily";
                break;
            case "muscle pain":
                medicine = "Diclofenac";
                dosage = "50 mg every 8 hours for 3 days";
                break;
            default:
                medicine = "Consult doctor";
                dosage = "As per doctor's advice";
        }

        prescriptionArea.setText("Medicine: " + medicine + "\nDosage: " + dosage);

        // Save the prescription to the database
        savePrescription(problem, medicine, dosage);
    }

    private void savePrescription(String problem, String medicine, String dosage) {
        Connection connection = DBConnection.getConnection();
        try {
            // Step 1: Save to the 'prescriptions' table
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO prescriptions (patient_id, problem, medicine, dosage) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, patientId); // Use the patient ID passed from RegisterPatient
            stmt.setString(2, problem);
            stmt.setString(3, medicine);
            stmt.setString(4, dosage);
            stmt.executeUpdate();

            // Step 2: Also save to 'patient_prescriptions' table (if it is a separate combined table)
            // Assuming 'patient_prescriptions' table has columns: (name, phone, problem, medicine, dosage)
            PreparedStatement patientPrescriptionStmt = connection.prepareStatement(
                "INSERT INTO patient_prescriptions (name, phone, problem, medicine, dosage) VALUES (?, ?, ?, ?, ?)"
            );
            
            // Fetch patient details based on patientId from the 'patients' table
            PreparedStatement fetchPatientStmt = connection.prepareStatement("SELECT name, phone FROM patients WHERE id = ?");
            fetchPatientStmt.setInt(1, patientId);
            ResultSet patientRs = fetchPatientStmt.executeQuery();
            
            if (patientRs.next()) {
                String patientName = patientRs.getString("name");
                String patientPhone = patientRs.getString("phone");
                
                // Now insert into patient_prescriptions
                patientPrescriptionStmt.setString(1, patientName);
                patientPrescriptionStmt.setString(2, patientPhone);
                patientPrescriptionStmt.setString(3, problem);
                patientPrescriptionStmt.setString(4, medicine);
                patientPrescriptionStmt.setString(5, dosage);
                patientPrescriptionStmt.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}