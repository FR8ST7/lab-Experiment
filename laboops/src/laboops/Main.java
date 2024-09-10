package laboops;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Square square = createSquare(scanner);
        displayShapeDetails(square);

        Rectangle rectangle = createRectangle(scanner);
        displayShapeDetails(rectangle);

        scanner.close();
    }

    public static Square createSquare(Scanner scanner) {
        System.out.println("Enter the color of the Square:");
        String color = scanner.nextLine();
        System.out.println("Enter the side length of the Square:");
        double sideLength = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        return new Square(color, sideLength);
    }

    public static Rectangle createRectangle(Scanner scanner) {
        System.out.println("Enter the color of the Rectangle:");
        String color = scanner.nextLine();
        System.out.println("Enter the length of the Rectangle:");
        double length = scanner.nextDouble();
        System.out.println("Enter the width of the Rectangle:");
        double width = scanner.nextDouble();
        scanner.nextLine(); 
        return new Rectangle(color, length, width);
    }

    public static void displayShapeDetails(Shape shape) {
        System.out.println("\n" + shape.getClass().getSimpleName() + " Details:");
        shape.display();
        System.out.println();
    }
}
