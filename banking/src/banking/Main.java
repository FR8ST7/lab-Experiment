package banking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank account = createAccount(scanner);

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    performDeposit(scanner, account);
                    break;
                case 2:
                    performWithdraw(scanner, account);
                    break;
                case 3:
                    performBalanceEnquiry(account);
                    break;
                case 4:
                    performDisplay(account);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static Bank createAccount(Scanner scanner) {
        System.out.println("Enter account name:");
        String accName = scanner.nextLine();
        System.out.println("Enter account number:");
        String accNo = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return new Bank(accName, accNo, balance);
    }

    private static void displayMenu() {
        System.out.println("\nBanking Operations:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Balance Enquiry");
        System.out.println("4. View Account Details");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void performDeposit(Scanner scanner, Bank account) {
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        account.deposit(amount);
    }

    private static void performWithdraw(Scanner scanner, Bank account) {
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        account.withdraw(amount);
    }

    private static void performBalanceEnquiry(Bank account) {
        System.out.println("Current balance: " + account.viewBalance());
    }

    private static void performDisplay(Bank account) {
        account.display();
    }
}
