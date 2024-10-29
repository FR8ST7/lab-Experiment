package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame implements ActionListener {
    private JButton yesButton, noButton, closeButton;
    private JLabel messageLabel;

    public ButtonFrame() {
        // Set up the frame
        setTitle("Power buttons");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize buttons and label
        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        closeButton = new JButton("Close");
        messageLabel = new JLabel("");

        // Add action listeners to buttons
        yesButton.addActionListener(this);
        noButton.addActionListener(this);
        closeButton.addActionListener(this);

        // Add components to the frame
        add(yesButton);
        add(noButton);
        add(closeButton);
        add(messageLabel);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button was pressed and set the label text accordingly
        if (e.getSource() == yesButton) {
            messageLabel.setText("Button Yes is pressed");
        } else if (e.getSource() == noButton) {
            messageLabel.setText("Button No is pressed");
        } else if (e.getSource() == closeButton) {
            // Close the frame
            dispose();
        }
    }

    public static void main(String[] args) {
        // Create an instance of the frame
        new ButtonFrame();
    }
}
