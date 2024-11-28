package Lecture4_interfaces_abstract_classes;

import exceptions.InsufficientFundsException;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    // Method to print the current balance
    public void printBalance() {
        System.out.println("Current Balance: " + getBalance());
    }

    // Method to apply a transaction (deposit or withdrawal)
    public void applyTransaction(BaseTransaction transaction) throws InsufficientFundsException {
        if (transaction instanceof WithdrawalTransaction) {
            // Check if the withdrawal amount is greater than the available balance
            if (this.balance < transaction.getAmount()) {
                throw new InsufficientFundsException("Insufficient funds for this withdrawal.");
            }
            this.balance -= transaction.getAmount();  // Deduct the balance for withdrawal
        } else if (transaction instanceof DepositTransaction) {
            this.balance += transaction.getAmount();  // Add the amount for deposit
        }
    }
}