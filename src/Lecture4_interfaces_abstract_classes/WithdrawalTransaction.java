package Lecture4_interfaces_abstract_classes;


import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

// Method to check if the withdrawal amount is valid (non-negative)
private boolean checkWithdrawalAmount(double amt) {
    return amt >= 0;
}

    // Method to reverse the transaction
    public boolean reverse() {
        return true;
    } // return true if reversal was successful

    /*
    Oportunity for assignment: implementing different form of withdrawal
     */
    public void apply(BankAccount ba) {
        double currentBalance = ba.getBalance();

        // Ensure the withdrawal amount is positive
        if (!checkWithdrawalAmount(getAmount())) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        // Check if there are sufficient funds for the withdrawal
        if (currentBalance >= getAmount()) {
            double newBalance = currentBalance - getAmount();
            ba.setBalance(newBalance);
            System.out.println("Withdrawal of " + getAmount() + " applied successfully.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    // Method to print the transaction details
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction:");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */
}