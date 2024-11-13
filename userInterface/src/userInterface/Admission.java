package userInterface;

import java.util.Scanner;
class Department {
 protected String deptName;
 protected String hodName;
 protected int noOfFaculty;
 protected int noOfStudents;
 protected int noOfPrograms;
 public Department(String deptName, String hodName, int noOfFaculty, int noOfStudents, int
noOfPrograms) {
 this.deptName = deptName;
 this.hodName = hodName;
 this.noOfFaculty = noOfFaculty;
 this.noOfStudents = noOfStudents;
 this.noOfPrograms = noOfPrograms;
 }
 public void displayDetails() {
 System.out.println("Department: " + deptName);
 System.out.println("HOD: " + hodName);
 System.out.println("Number of Faculty: " + noOfFaculty);
 System.out.println("Number of Students: " + noOfStudents);
 System.out.println("Number of Programs: " + noOfPrograms);
 System.out.println();
 }
}
class CSE extends Department {
 public CSE(String hodName, int noOfFaculty, int noOfStudents, int noOfPrograms) {
 super("CSE", hodName, noOfFaculty, noOfStudents, noOfPrograms);
 }
}
class AI_DS extends Department {
 public AI_DS(String hodName, int noOfFaculty, int noOfStudents, int noOfPrograms) {
 super("AI&DS", hodName, noOfFaculty, noOfStudents, noOfPrograms);
 }
}
class CE extends Department {
 public CE(String hodName, int noOfFaculty, int noOfStudents, int noOfPrograms) {
 super("CE", hodName, noOfFaculty, noOfStudents, noOfPrograms);
 }
}
class AllDepartment { 
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 Department[] departments = new Department[3];
 System.out.println("Enter details for CSE Department:");
 departments[0] = getDepartmentDetails(new CSE("", 0, 0, 0), sc);
 System.out.println("Enter details for AI&DS Department:");
 departments[1] = getDepartmentDetails(new AI_DS("", 0, 0, 0), sc);
 System.out.println("Enter details for CE Department:");
 departments[2] = getDepartmentDetails(new CE("", 0, 0, 0), sc);
 while (true) {
 System.out.println("Menu:");
 System.out.println("1. Display all department details");
 System.out.println("2. Display CSE department details");
 System.out.println("3. Display AI&DS department details");
 System.out.println("4. Display CE department details");
 System.out.println("5. Exit");
 System.out.print("Choose an option: ");
 int choice = sc.nextInt();
 sc.nextLine();
 switch (choice) {
 case 1:
 for (Department dept : departments) {
 dept.displayDetails();
 }
 break;
 case 2:
 departments[0].displayDetails();
 break;
 case 3:
 departments[1].displayDetails();
 break;
 case 4:
 departments[2].displayDetails();
 break;
 case 5:
 System.out.println("Exiting...");
 sc.close();
 return;
 default:
 System.out.println("Invalid choice. Please try again.");
 }
}
 }
 private static Department getDepartmentDetails(Department dept, Scanner sc) {
 System.out.print("Enter HOD Name: ");
 String hodName = sc.nextLine();
 System.out.print("Enter Number of Faculty: ");
 int noOfFaculty = sc.nextInt();
 System.out.print("Enter Number of Students: ");
 int noOfStudents = sc.nextInt();
 System.out.print("Enter Number of Programs: ");
 int noOfPrograms = sc.nextInt();
 sc.nextLine();
 return new Department(dept.deptName, hodName, noOfFaculty, noOfStudents,
noOfPrograms);
 }
}
