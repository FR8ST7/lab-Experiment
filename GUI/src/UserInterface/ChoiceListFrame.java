package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceListFrame extends JFrame implements ActionListener {
    private JComboBox<String> subjectList;
    private JTextField displayField;

    public ChoiceListFrame() {
        // Set up the frame
        setTitle("Subject Choice Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the choice selection
        JPanel choicePanel = new JPanel(new FlowLayout());
        JLabel choiceLabel = new JLabel("Select a subject:");
        choicePanel.add(choiceLabel);

        // Initialize choice list with subject names
        String[] subjects = {"Mathematics", "Physics", "Chemistry", "Biology", "Computer Science"};
        subjectList = new JComboBox<>(subjects);
        subjectList.addActionListener(this);
        choicePanel.add(subjectList);

        // Create a panel for displaying the selected subject
        JPanel displayPanel = new JPanel(new FlowLayout());
        JLabel displayLabel = new JLabel("Selected Subject:");
        displayPanel.add(displayLabel);

        displayField = new JTextField(20);
        displayField.setEditable(false);  // Make the text field read-only
        displayPanel.add(displayField);

        // Add panels to the frame
        add(choicePanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Display the selected subject in the text field
        if (e.getSource() == subjectList) {
            String selectedSubject = (String) subjectList.getSelectedItem();
            displayField.setText(selectedSubject);
        }
    }

    public static void main(String[] args) {
        // Create an instance of the frame
        new ChoiceListFrame();
    }
}
