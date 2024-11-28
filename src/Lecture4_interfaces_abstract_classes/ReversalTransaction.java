package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class ReversalTransaction extends BaseTransaction {

    private final boolean isReversed = true;
    // Change the constructor to accept a double amount
    public ReversalTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
        if (amount <= 0) {
            throw new IllegalArgumentException("Reversal amount must be positive.");
        }
    }

    @Override
    public void apply(BankAccount ba) {
        if (ba == null) {
            throw new NullPointerException("BankAccount cannot be null.");
        }

        double currentBalance = ba.getBalance();
        double amountToReverse = getAmount();
        ba.setBalance(currentBalance + amountToReverse);
        System.out.println("Reversal of " + amountToReverse + " applied successfully.");
    }

 @Override
    public void printTransactionDetails() {
        System.out.println("Reversal Transaction:");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Reversed: " + (isReversed ? "Yes" : "No"));
    }
}