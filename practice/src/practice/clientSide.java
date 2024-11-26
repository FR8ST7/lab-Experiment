package practice;

import java.io.*;
import java.net.*;

public class clientSide {

    // Initialize socket and input/output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // Constructor to establish a connection with the server
    public clientSide(String address, int port) {
        try {
            // Establish connection
            socket = new Socket(address, port);
            System.out.println("Connected");

            // Input from terminal
            input = new DataInputStream(System.in);

            // Output to the socket
            out = new DataOutputStream(socket.getOutputStream());

            // String to read message from input
            String line = "";

            // Keep reading until "End" is input
            while (!line.equals("End")) {
                try {
                    System.out.print("Enter message: ");
                    line = input.readLine(); // Read input from the terminal
                    out.writeUTF(line);      // Send the input to the server
                } catch (IOException e) {
                    System.out.println("Error sending message: " + e);
                }
            }

            // Close the connection
            input.close();
            out.close();
            socket.close();
        } catch (UnknownHostException u) {
            System.out.println("Unknown host: " + u);
        } catch (IOException i) {
            System.out.println("I/O error: " + i);
        }
    }

    public static void main(String[] args) {
        // Replace "127.0.0.2" with the correct IP address of the server
        clientSide client = new clientSide("127.0.0.1", 6006);
    }
}
