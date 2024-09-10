package banking;

class Bank extends Account implements Transaction, Displayable {

    Bank(String accName, String accNo, double balance) {
        super(accName, accNo, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn " + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal");
        }
    }

    @Override
    public double viewBalance() {
        return balance;
    }

    @Override
    public void display() {
        System.out.println("Account Name: " + accName);
        System.out.println("Account Number: " + accNo);
        System.out.println("Balance: " + balance);
    }
}
