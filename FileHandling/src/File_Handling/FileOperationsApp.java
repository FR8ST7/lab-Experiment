package File_Handling;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class FileOperationsApp {
    private static final String FILE_NAME = "findMyStuff.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Open an existing file");
            System.out.println("2. Create a new file");
            System.out.println("3. Rename a file");
            System.out.println("4. Delete a file");
            System.out.println("5. Create a directory");
            System.out.println("6. Find the absolute path of a file");
            System.out.println("7. Get file names of a directory");
            System.out.println("8. Extract words starting with 'S'");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> openFile();
                case 2 -> createNewFile();
                case 3 -> renameFile(scanner);
                case 4 -> deleteFile();
                case 5 -> createDirectory(scanner);
                case 6 -> findAbsolutePath();
                case 7 -> getDirectoryFileNames(scanner);
                case 8 -> extractWordsStartingWithS();
                case 9 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void openFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("File contents:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found or could not be opened.");
        }
    }

    private static void createNewFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
        }
    }

    private static void renameFile(Scanner scanner) {
        System.out.print("Enter new file name: ");
        String newFileName = scanner.nextLine();
        File oldFile = new File(FILE_NAME);
        File newFile = new File(newFileName);
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("Failed to rename file.");
        }
    }

    private static void deleteFile() {
        File file = new File(FILE_NAME);
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    private static void createDirectory(Scanner scanner) {
        System.out.print("Enter directory name: ");
        String dirName = scanner.nextLine();
        File dir = new File(dirName);
        if (dir.mkdir()) {
            System.out.println("Directory created successfully.");
        } else {
            System.out.println("Failed to create directory.");
        }
    }

    private static void findAbsolutePath() {
        File file = new File(FILE_NAME);
        System.out.println("Absolute path: " + file.getAbsolutePath());
    }

    private static void getDirectoryFileNames(Scanner scanner) {
        System.out.print("Enter directory name: ");
        String dirName = scanner.nextLine();
        File dir = new File(dirName);
        if (dir.isDirectory()) {
            String[] files = dir.list();
            System.out.println("Files in directory:");
            if (files != null) {
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Not a valid directory.");
        }
    }

    private static void extractWordsStartingWithS() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Words that start with 'S' or 's':");
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.toLowerCase().startsWith("s")) {
                        System.out.println(word);
                        count++;
                    }
                }
            }
            System.out.println("Total count of words starting with 'S' or 's': " + count);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
