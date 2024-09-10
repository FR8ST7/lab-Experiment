package oopslab;
import java.util.Scanner;
 class Shape {

	 private double dim1, dim2;
	 void setDimensions(double dim1, double dim2) {
	 this.dim1 = dim1;
	 this.dim2 = dim2;
	 }
	 double getDim1() {
	 return dim1;
	 }
	 double getDim2() {
	 return dim2;
	 }
	 double findArea() {
	 return 0;
	 }
	}
	class Triangle extends Shape {
	 @Override
	 double findArea() {
	 return 0.5 * getDim1() * getDim2();
	 }
	}
	class Rectangle extends Shape {
	 @Override
	 double findArea() {
	 return getDim1() * getDim2();
	 }
	}
	class Main {
	 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 Shape shape = null;
	System.out.println("1. Triangle\n2. Rectangle\nChoose shape: ");
	 int choice = sc.nextInt();
	 if (choice == 1) {
	 shape = new Triangle();
	 } else if (choice == 2) {
	 shape = new Rectangle();
	 }
	 if (shape != null) {
	 System.out.print("Enter dimensions: ");
	 double dim1 = sc.nextDouble();
	 double dim2 = sc.nextDouble();
	 shape.setDimensions(dim1, dim2);
	 System.out.println("Area: " + shape.findArea());
	 } else {
	 System.out.println("Invalid choice");
	 }
	 sc.close();
	 }
	}

