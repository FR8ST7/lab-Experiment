package banking;

abstract class Account {
    String accName;
    String accNo;
    double balance;

    Account(String accName, String accNo, double balance) {
        this.accName = accName;
        this.accNo = accNo;
        this.balance = balance;
    }
}
