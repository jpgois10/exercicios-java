package entities;

public class Account {
    private int accountNumber;
    private String holderName;
    private double accountBalance;

    public Account(int accountNumber, String holderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        deposit(initialDeposit);
    }

    public Account(int accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.accountBalance = 0.00;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdraw(double amount) {
        accountBalance -= amount + 5.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getClientName() {
        return holderName;
    }

    public void setClientName(String holderName) {
        this.holderName = holderName;
    }


    public double getAccountBalance() {
        return accountBalance;
    }

    public String toString() {
        return "Account "
                + accountNumber
                + ", Holder: "
                + holderName
                + ", Balance: $ "
                + String.format("%.2f", accountBalance);
    }
}
