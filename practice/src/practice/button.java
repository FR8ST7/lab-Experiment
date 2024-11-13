package practice;
import javax.swing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListner;

public class button extends JFrame implements ActionListener {
	public JButton yesButton,noButton,closeButton;
	public JLabel messageLabel;
    
	public button() {
		setTitle("power buttons");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		yesButton= new JButton("yes");
		noButton= new JButton("no");
		closeButton= new jButton("close");
		messageLabel= new JLabel("");
		
		add(yesButton);
		add(noButton);
		add(closeButton);
		add(messageLabel);
		
		setVisible(true);
	}
	public void perform(ActionEvent e) {
		if(e.getSource()==yesButton) {
			messageLabel.setText("yes pressed");
		}
		else if(e.getSource==noButton) {
			messageLabel.getText("no pressed");
		}
		else if(e.getSource==closeButton) {
			dispose();
		}
	}
	public static void main(String args[]) {
		new button();
	}
}
