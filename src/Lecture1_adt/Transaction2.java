package Lecture1_adt;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
//import java.util.Date;

/**
 * This Lecture1_adt.Transaction2 Class Takes the first step to resolves the ADT design issues of Transaction1:
 * 1. Representation Independence: --- Encapsulation - Providing access methods to the internal data.
 *                                     External client code only access via allowable operations
 *                                 --- Changes to internal representation can still be accessed via same methods defined
 *
 * 2. Preservation of Invariants: --- Access Modifies private final makes the data Unchangeable
 *
 * Lecture1_adt
 */

public class Transaction2 {
    private final int amount;
    private final Calendar date;

    public Transaction2(int amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    public Calendar getDate() {
//        return date;    // Because we are dealing with Reference types we need to judiciously copy what our getters return
        return (Calendar) date.clone(); // Defensive copying or Judicious Copying
    }
}
