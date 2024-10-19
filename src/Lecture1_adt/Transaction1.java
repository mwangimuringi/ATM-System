package Lecture1_adt;

import java.util.Calendar;

/**
 * This Lecture1_adt.TransactionInterface Class violates several ADT design principles:
 * 1. Representation Independence: --- Changes in representation of the data may require external code to alter access
 * 2. Preservation of Invariants: --- Any external client code can alter the internal values
 */
public class Transaction1 {
    public int amount;
    public Calendar date;

    public Transaction1(int amount, Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
    }
}
