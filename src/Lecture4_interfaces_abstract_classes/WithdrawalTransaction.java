package Lecture4_interfaces_abstract_classes;

import exceptions.InsufficientFundsException;
import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
    }

    private boolean checkWithdrawalAmount(double amt) {
        return amt >= 0;
    }
    @Override
    public void apply(BankAccount ba) {
        apply(ba, "Standard Withdrawal"); // Default to "Standard Withdrawal" type
    }

    public void apply(BankAccount ba, String withdrawalType) {
        if (ba == null) {
            throw new NullPointerException("BankAccount cannot be null.");
        }

        double currentBalance = ba.getBalance();

        try {
            // If withdrawal amount is greater than balance, throw custom exception
            if (currentBalance < getAmount()) {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }

            // If amount is valid, perform the withdrawal
            double newBalance = currentBalance - getAmount();
            ba.setBalance(newBalance);
            System.out.println("Withdrawal of " + getAmount() + " (" + withdrawalType + ") applied successfully.");

        } catch (InsufficientFundsException e) {
            // Handle exception and print error message
            System.out.println(e.getMessage());
        }
    }

    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction:");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }

    // Reverse method to create a ReversalTransaction
    public ReversalTransaction reverse(BankAccount ba) {
        if (ba == null) {
            throw new NullPointerException("BankAccount cannot be null.");
        }

        double currentBalance = ba.getBalance();
        ba.setBalance(currentBalance + getAmount());

        // Create a reversal transaction with the withdrawal amount
        return new ReversalTransaction(this.getAmount(), this.getDate());
    }
}