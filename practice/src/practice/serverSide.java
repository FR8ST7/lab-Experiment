package practice;

import java.io.*;
import java.net.*;

public class serverSide {

    // Initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // Constructor with port
    public serverSide(int port) {
        try {
            // Start server and wait for a connection
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client...");

            // Accept client connection
            socket = server.accept();
            System.out.println("Client accepted");

            // Take input from the client socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // Read messages from the client until "End" is sent
            while (!line.equals("End")) {
                try {
                    line = in.readUTF(); // Read UTF-encoded string from client
                    System.out.println("Client: " + line);
                } catch (IOException e) {
                    System.out.println("Error reading message: " + e);
                }
            }

            System.out.println("Closing connection");

            // Close connection
            socket.close();
            in.close();
        } catch (IOException e) {
            System.out.println("Server error: " + e);
        }
    }

    public static void main(String[] args) {
        // Start the server on port 6006
        serverSide server = new serverSide(6006);
    }
}
