package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {
    /**
     * Constructor for DepositTransaction.
     *
     * @param amount: Must be a positive integer representing the deposit amount.
     * @param date: Not null, must be a Calendar object representing the transaction date.
     * Initializes the deposit transaction fields.
     *
     * Requires:
     * - `amount` > 0.
     * - `date` is not null.
     * Produces:
     * - A valid DepositTransaction object with specified amount and date.
     * Throws:
     * - IllegalArgumentException if `amount` <= 0.
     * - NullPointerException if `date` is null.
     */
    public DepositTransaction(int amount, @NotNull Calendar date) {
        super(amount, date); // Calls the BaseTransaction constructor
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }
    private boolean checkDepositAmount(int amt) {
        return amt >= 0;
    }
    // Method to print a transaction receipt or details
    public void printTransactionDetails(){
        System.out.println("Deposit Trasaction: "+this.toString());
    }

    public void apply(BankAccount ba) {
        if (ba == null) {
            throw new NullPointerException("BankAccount cannot be null.");
        }

        double currBalance = ba.getBalance();
        double newBalance = currBalance + getAmount();
        ba.setBalance(newBalance); // Update account balance
        System.out.println("Deposit of " + getAmount() + " applied successfully.");
    }
}
