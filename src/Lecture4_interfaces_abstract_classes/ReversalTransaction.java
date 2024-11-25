package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class ReversalTransaction extends BaseTransaction {

    private boolean isReversed = true;

    // Change the constructor to accept a double amount
    public ReversalTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    public void apply(BankAccount ba) {
        double currentBalance = ba.getBalance();
        double amountToReverse = getAmount();
        ba.setBalance(currentBalance + amountToReverse);
        System.out.println("Reversal of " + amountToReverse + " applied successfully.");
    }

    public void printTransactionDetails() {
        System.out.println("Reversal Transaction:");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Reversed: " + (isReversed ? "Yes" : "No"));
    }
}
