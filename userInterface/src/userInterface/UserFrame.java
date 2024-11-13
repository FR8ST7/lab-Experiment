package userInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserFrame extends JFrame implements ActionListener {
	public JButton login;
	public JTextField user;
	public JLabel ul,pl;
	public JPasswordField pass;
	
	public UserFrame() {
		setTitle("login");
		setSize(300,300);
		setDefaultCloseOperation();
		setLayout(new FlowLayout());
		
		login= new JButton("login");
		user= new JTextField(20);
		ul= new JLabel("username");
		pl=new JLabel("password");
		pass=new JPasswordField(15);
		
		login.addActionListener(this);
		
		
		
	}
	@Override 
	public void actionPerformed(ActionEvent e) {
		String username= user.getText();
		String password= new String(pass.getPassword());
		if(username.equals("karunya")&&password.equals("karunya")) {
			JOptionPane.showMessageDialog(this,"");
		}
	}

}
