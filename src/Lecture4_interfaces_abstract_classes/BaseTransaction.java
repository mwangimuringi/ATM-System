package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public abstract class BaseTransaction implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;

    /**
     * Lecture1_adt.TransactionInterface Constructor
     * @param amount in an integer
     * @param date: Not null, and must be a Calendar object
     * @return void
     * Instialises the field, attributes of a transaction
     * Creates a object of this
     */
    public BaseTransaction(double amount, @NotNull Calendar date)  {
        this.amount = amount;
        this.date = (Calendar) date.clone();//defensive copy of date
        this.transactionID = generateTransactionID(date);
    }
    /**
     * Generates a unique transaction ID based on the date and a random value
     * @param date: The transaction date to be used for ID generation
     * @return A unique transaction ID string
     */
    private String generateTransactionID(Calendar date) {
        int uniq = (int) (Math.random() * 10000);
        return date.getTime().toString() + "-" + uniq; // Combine date string and random number
    }

    /**
     * Gets the transaction amount
     * @return The transaction amount as double
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the transaction date
     * @return A defensive copy of the transaction date
     */
    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copying to avoid external modification
    }

    /**
     * Gets the unique transaction ID
     * @return The transaction ID string
     */
    public String getTransactionID() {
        return transactionID;
    }

    // Abstract methods that must be implemented by subclasses
    public abstract void printTransactionDetails();
    public abstract void apply(BankAccount ba);
}