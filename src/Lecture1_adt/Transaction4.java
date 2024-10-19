package Lecture1_adt;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
/**
 * There is still Exposure seen in Transaction3 in that if we make a list of 12 payments,
 *                 the date of all payments remain the same.
 * This Class Transaction4:Adds Code to correct this exposure:
 * In Making th List of 12 Transactions, we are constantly using the constructor which takes a Date Object
 * Intentional review of any methods that receives or requires (i.e. takes in as parameters)
 *              If requires interface of a method deals with objects or any reference types,
 *              there is need to perform defensive copying to enhance Invariant preservation
 */
public class Transaction4 {
    private final int amount;
    private final Calendar date;

    public Transaction4(int amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone();  // Defensive copying or Judicious Copying for Requires interfaces
    }

    public int getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    public Calendar getDate() {
//        return date;    // Because we are dealing with Reference types we need to judiciously copy what our getters return
        return (Calendar) date.clone(); // Defensive copying or Judicious Copying for produces Interfaces
    }
}
