package Lecture2_adt_specification;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
//import java.util.Date;

/**
 * In Addition to the Design considerations in Transaction4 class:
 * This class adds Specifications defining the Requires and Produces interfaces
 */

public class Transaction4 {
    private final int amount;
    private final Calendar date;

    /**
     * Lecture1_adt.TransactionInterface Constructor
     * @param amount in an integer
     * @param date: Not null, and must be a Calendar object
     * @return void
     * Instialises the field, attributes of a transaction
     * Creates a object of this
     */
    public Transaction4(int amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
    }


    /**
     * getAmount()
     * @return integer
     */
    public int getAmount() {
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
}
