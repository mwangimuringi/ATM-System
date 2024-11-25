package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkWithdrawalAmount(double amt) {
        return amt >= 0;
    }

    public void apply(BankAccount ba) {
        double currentBalance = ba.getBalance();

        if (!checkWithdrawalAmount(getAmount())) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (currentBalance >= getAmount()) {
            double newBalance = currentBalance - getAmount();
            ba.setBalance(newBalance);
            System.out.println("Withdrawal of " + getAmount() + " applied successfully.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
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
        double currentBalance = ba.getBalance();
        ba.setBalance(currentBalance + getAmount());

        // Create a reversal transaction with a double amount
        return new ReversalTransaction(this.getAmount(), this.getDate());
    }
}
