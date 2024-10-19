package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public abstract class BaseTransaction implements TransactionInterface {
    private final int amount;
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
    public BaseTransaction(int amount, @NotNull Calendar date)  {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        int uniq = (int) Math.random()*10000;
        transactionID = date.toString()+uniq;
    }

    /**
     * getAmount()
     * @return integer
     */
    public double getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    /**
     * getDate()
     * @return Calendar Object
     */
    public Calendar getDate() {
//        return date;    // Because we are dealing with Reference types we need to judiciously copy what our getters return
        return (Calendar) date.clone(); // Defensive copying or Judicious Copying
    }

    // Method to get a unique identifier for the transaction
    public String getTransactionID(){
        return  transactionID;
    }
    // Method to print a transaction receipt or details
    public abstract void printTransactionDetails();
    public abstract void apply(BankAccount ba);
}
