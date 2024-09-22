package practice;

import java.util.Scanner;

public class counting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int y = sc.nextInt();

        char[] x = new char[y];
        System.out.println("Enter the elements:");

        for (int i = 0; i < y; i++) {
            x[i] = sc.next().charAt(0);
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enter the element to search");
            System.out.println("2. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int c = 0;
                    System.out.println("Enter the element:");
                    char b = sc.next().charAt(0);

                    for (int i = 0; i < y; i++) {
                        if (x[i] == b) {
                            c++;
                        }
                    }
                    System.out.println("The occurrence of " + b + ": " + c);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        } while (choice != 2); 

        sc.close();
    }
}