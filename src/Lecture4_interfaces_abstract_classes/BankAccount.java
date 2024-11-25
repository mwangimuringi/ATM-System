package Lecture4_interfaces_abstract_classes;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to print the current balance
    public void printBalance() {
        System.out.println("Current Balance: " + getBalance());
    }

    // Method to apply a transaction (deposit or withdrawal)
    public void applyTransaction(BaseTransaction transaction) {
        if (transaction instanceof WithdrawalTransaction) {
            this.balance -= transaction.getAmount();
        } else if (transaction instanceof DepositTransaction) {
            this.balance += transaction.getAmount();
        }
    }
}
