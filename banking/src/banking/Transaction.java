package banking;

interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
    double viewBalance();
}
