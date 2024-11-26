package File_Handling;

import java.io.*;

public class FileReaderExample {

    public static void main(String[] args) {
        // Specify the file path (replace with your file's path)
        String filePath = "example.txt";

        // Try-with-resources to automatically close resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("File content:");

            // Read and print each line from the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}
