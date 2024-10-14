package practice;
import javax.swing.JFrame;
import javax.swing.JButton;
public class swingexp {
	    public static void main(String[] args) {
	        // Create a frame (window)
	        JFrame frame = new JFrame("My Swing Application");
	        frame.setSize(400, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Create a button
	        JButton button = new JButton("Click Me!");
	        frame.add(button); // Add the button to the frame

	        // Make the frame visible
	        frame.setVisible(true);
	    }
	}

