package arithmetic;

import java.util.Scanner;

public class ScientificCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Add add = new Add();
        Subtract subtract = new Subtract();
        Multiply multiply = new Multiply();
        Divide divide = new Divide();
        Modulus modulus = new Modulus();
        Sine sine = new Sine();
        Cosine cosine = new Cosine();
        Tangent tangent = new Tangent();

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    performAddition(scanner, add);
                    break;
                case 2:
                    performSubtraction(scanner, subtract);
                    break;
                case 3:
                    performMultiplication(scanner, multiply);
                    break;
                case 4:
                    performDivision(scanner, divide);
                    break;
                case 5:
                    performModulus(scanner, modulus);
                    break;
                case 6:
                    performSine(scanner, sine);
                    break;
                case 7:
                    performCosine(scanner, cosine);
                    break;
                case 8:
                    performTangent(scanner, tangent);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nScientific Calculator:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Modulus");
        System.out.println("6. Sine");
        System.out.println("7. Cosine");
        System.out.println("8. Tangent");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void performAddition(Scanner scanner, Add add) {
        System.out.println("Enter two numbers to add:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("Result: " + add.add(a, b));
    }

    private static void performSubtraction(Scanner scanner, Subtract subtract) {
        System.out.println("Enter two numbers to subtract:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("Result: " + subtract.subtract(a, b));
    }

    private static void performMultiplication(Scanner scanner, Multiply multiply) {
        System.out.println("Enter two numbers to multiply:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("Result: " + multiply.multiply(a, b));
    }

    private static void performDivision(Scanner scanner, Divide divide) {
        System.out.println("Enter two numbers to divide:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("Result: " + divide.divide(a, b));
    }

    private static void performModulus(Scanner scanner, Modulus modulus) {
        System.out.println("Enter two numbers to find modulus:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("Result: " + modulus.modulus(a, b));
    }

    private static void performSine(Scanner scanner, Sine sine) {
        System.out.println("Enter an angle in degrees to find sine:");
        double angle = scanner.nextDouble();
        System.out.println("Result: " + sine.sine(angle));
    }

    private static void performCosine(Scanner scanner, Cosine cosine) {
        System.out.println("Enter an angle in degrees to find cosine:");
        double angle = scanner.nextDouble();
        System.out.println("Result: " + cosine.calculateCosine(angle));
    }

    private static void performTangent(Scanner scanner, Tangent tangent) {
        System.out.println("Enter an angle in degrees to find tangent:");
        double angle = scanner.nextDouble();
        System.out.println("Result: " + tangent.calculateTangent(angle));
    }
}
