package userInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame implements ActionListener{
	public JButton yes,no,close;
	public JLabel message;
	
	public ButtonFrame() {
	setTitle("power buttons");
	setSize(300,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	
	yes= new JButton("yes");
	no= new JButton("no");
	close= new JButton("close");
	message= new JLabel("");
	
	yes.addActionListener(this);
	no.addActionListener(this);
    close.addActionListener(this);
    
    add(yes);
    add(no);
    add(close);
    add(message);
    
    setVisible(true);
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==yes) {
				message.setText("yes pressed");
			}
			else if(e.getSource()==no) {
				message.setText("no pressed");
		}
			else if(e.getSource()==close) {
				dispose();
		}
	}
	public static void main(String args[]) {
		new ButtonFrame();
	}
}
