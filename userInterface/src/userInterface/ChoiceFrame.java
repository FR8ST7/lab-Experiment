package userInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceFrame extends JFrame implements ActionListener{
	public JComboBox<String>List;
	public JTextField display;
	
	public ChoiceFrame() {
	setTitle("power buttons");
	setSize(300,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new BorderLayout());
	
	JPanel choicePanel= new JPanel(new FlowLayout());
	JLabel choiceLabel= new JLabel("select subject");
	choicePanel.add(choiceLabel);
	
	JPanel displayPanel= new JPanel(new FlowLayout());
	JLabel displayLabel= new JLabel("select subject");
	displayPanel.add(displayLabel);
	
	String subjects[]= {"maths","physics"};
	List= new JComboBox<>(subjects);
	List.addActionListener(this);
	choicePanel.add(List);
	
	display= new JTextField(20);
	display.setEditable(false);
	displayPanel.add(display);
	
	add(choicePanel,BorderLayout.NORTH);
	add(displayPanel,BorderLayout.CENTER);
    setVisible(true);
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==List) {
				String ss= (String)List.getSelectedItem();
				display.setText(ss);
			}
		
	}
	public static void main(String args[]) {
		new ChoiceFrame();
	}
}
