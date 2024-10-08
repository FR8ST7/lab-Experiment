package javaSWING;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class addnumbers {

	    public static void main(String[] args) {
	        // Create a new frame
	        JFrame frame = new JFrame("Add Two Numbers");
	        
	        // Create Labels
	        JLabel label1 = new JLabel("Number 1:");
	        label1.setBounds(50, 50, 100, 30); // Set position and size
	        
	        JLabel label2 = new JLabel("Number 2:");
	        label2.setBounds(50, 100, 100, 30);
	        
	        JLabel resultLabel = new JLabel("Result:");
	        resultLabel.setBounds(50, 150, 100, 30);

	        // Create Text Fields
	        JTextField text1 = new JTextField();
	        text1.setBounds(150, 50, 150, 30);
	        
	        JTextField text2 = new JTextField();
	        text2.setBounds(150, 100, 150, 30);
	        
	        JTextField resultText = new JTextField();
	        resultText.setBounds(150, 150, 150, 30);
	        resultText.setEditable(false);  // Result field should not be editable

	        // Create Button
	        JButton addButton = new JButton("Add");
	        addButton.setBounds(150, 200, 80, 30);

	        // Add action listener to the button
	        addButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    // Get the numbers from the text fields
	                    double num1 = Double.parseDouble(text1.getText());
	                    double num2 = Double.parseDouble(text2.getText());

	                    // Calculate the sum
	                    double result = num1 + num2;

	                    // Display the result
	                    resultText.setText(String.valueOf(result));
	                } catch (NumberFormatException ex) {
	                    // If user enters non-numeric input
	                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });

	        // Add components to the frame
	        frame.add(label1);
	        frame.add(label2);
	        frame.add(resultLabel);
	        frame.add(text1);
	        frame.add(text2);
	        frame.add(resultText);
	        frame.add(addButton);

	        // Set frame properties
	        frame.setSize(400, 350);
	        frame.setLayout(null);  // No layout manager for absolute positioning
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	}


