package exception_handling;

import java.util.Scanner;

interface ATMOperations {
 void deposit(double amount);
 void withdraw(double amount) throws WithdrawException;
 void checkBalance();
 void changePIN(int newPIN);
}

class BalanceException extends Exception {
 public BalanceException(String message) {
     super(message);
 }
}

class WithdrawException extends Exception {
 public WithdrawException(String message) {
     super(message);
 }
}

class PinException extends Exception {
 public PinException(String message) {
     super(message);
 }
}

class BankAccount implements ATMOperations {
 private double balance;
 private int pin;
 private int pinAttempts = 0;

 public BankAccount(double initialBalance, int pin) throws BalanceException {
     if (initialBalance < 500) {
         throw new BalanceException("Initial balance cannot be less than 500");
     }
     this.balance = initialBalance;
     this.pin = pin;
 }

 @Override
 public void deposit(double amount) {
     balance += amount;
     System.out.println("Amount deposited: " + amount);
 }

 @Override
 public void withdraw(double amount) throws WithdrawException {
     if (balance < amount) {
         throw new WithdrawException("Insufficient balance for withdrawal");
     }
     balance -= amount;
     System.out.println("Amount withdrawn: " + amount);
 }

 @Override
 public void checkBalance() {
     System.out.println("Current balance: " + balance);
 }

 @Override
 public void changePIN(int newPIN) {
     pin = newPIN;
     System.out.println("PIN successfully changed");
 }

 public boolean validatePIN(int inputPIN) throws PinException {
     if (inputPIN == pin) {
         pinAttempts = 0;
         return true;
     } else {
         pinAttempts++;
         if (pinAttempts >= 3) {
             throw new PinException("Invalid PIN entered 3 times. Access blocked.");
         }
         return false;
     }
 }
}

public class ATMApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     BankAccount account = null;

     try {
         System.out.print("Enter initial balance: ");
         double initialBalance = scanner.nextDouble();
         System.out.print("Set your 4-digit PIN: ");
         int pin = scanner.nextInt();
         account = new BankAccount(initialBalance, pin);
         System.out.println("Account created successfully.");
     } catch (BalanceException e) {
         System.out.println(e.getMessage());
         return;
     }

     int choice;
     do {
         System.out.println("\n--- ATM Menu ---");
         System.out.println("1. Deposit");
         System.out.println("2. Withdraw");
         System.out.println("3. Check Balance");
         System.out.println("4. Change PIN");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         try {
             System.out.print("Enter your PIN: ");
             int enteredPIN = scanner.nextInt();
             if (!account.validatePIN(enteredPIN)) {
                 System.out.println("Incorrect PIN. Please try again.");
                 continue;
             }

             switch (choice) {
                 case 1:
                     System.out.print("Enter amount to deposit: ");
                     double depositAmount = scanner.nextDouble();
                     account.deposit(depositAmount);
                     break;

                 case 2:
                     System.out.print("Enter amount to withdraw: ");
                     double withdrawAmount = scanner.nextDouble();
                     account.withdraw(withdrawAmount);
                     break;

                 case 3:
                     account.checkBalance();
                     break;

                 case 4:
                     System.out.print("Enter new PIN: ");
                     int newPIN = scanner.nextInt();
                     account.changePIN(newPIN);
                     break;

                 case 5:
                     System.out.println("Thank you for using the ATM. Goodbye!");
                     break;

                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         } catch (WithdrawException | PinException e) {
             System.out.println("Error: " + e.getMessage());
         }
     } while (choice != 5);

     scanner.close();
 }
}

