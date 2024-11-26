package File_Handling;

import java.io.*;

public class FileWriteExample {

    public static void main(String[] args) {
        // Specify the file path (replace with your desired file path)
        String filePath = "example.txt";

        // Content to write to the file
        String content = "Hello, this is a sample content written to the file.\n"
                        + "You can add more lines as needed.";

        // Try-with-resources to automatically close the writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write content to the file
            writer.write(content);
            writer.newLine(); // Add a new line
            writer.write("This is another line of text.");

            System.out.println("Content written to the file successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
