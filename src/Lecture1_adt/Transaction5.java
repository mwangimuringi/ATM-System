package Lecture1_adt;

import java.util.Calendar;

public class Transaction5 {
    public  int amount;
    private  Calendar date;


    public int getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    public Calendar getDate() {
//        return date;    // Because we are dealing with Reference types we need to judiciously copy what our getters return
        return (Calendar) date.clone(); // Defensive copying or Judicious Copying
    }
}