import Lecture1_adt.*; // Import all classes from Lecture1_adt package to be used in this client code
import Lecture4_interfaces_abstract_classes.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
* Client Code for accessing the Lecture1_adt.TransactionInterface.java module
 */
public class Main {

    public static void testTransaction1() {
        Calendar d1 = new GregorianCalendar(); // d1 is an Object [Objects are Reference types]
        Lecture1_adt.Transaction1 t1 = new Lecture1_adt.Transaction1(1000, d1); // amount and d1 are arguments

        System.out.println(t1.toString());
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t1.amount);
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t1.date);

        // Please note that the Client Codes can access the data in the class directly through the dot operator
        // This kind of exposure is a threat to both the Representation Independence and Preservation of Invariants
    }


    /** @return a transaction of same amount as t, one month later
     * This is a PRODUCER of the class Lecture1_adt.Transaction2
     * This code will help demostrate the Design exposures still present in transaction2 class
     * */

    public static Transaction2 makeNextPayment(Transaction2 t) {
        Calendar d =  t.getDate();
        d.add(Calendar.MONTH, 1);
        return new Transaction2(t.getAmount(), d);
    }

    /*
    Testing Transaction2 class
     */
    public static void testTransaction2() {

        Calendar d1 = new GregorianCalendar();

        Lecture1_adt.Transaction2 t = new Lecture1_adt.Transaction2(1000, d1);
        Lecture1_adt.Transaction2 modified_t = makeNextPayment(t);

        System.out.println("\n\nState of the Object T1 After Client Code Tried to Change the Amount");
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+modified_t.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t "+modified_t.getDate().getTime());

        System.out.println("\n\nHow does T2 Look Like?????");
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+modified_t.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t "+modified_t.getDate().getTime());

        /* Please note that Although we have solved the problem of Transaction1
        * And client code can no longer use the dot (.) operator to directly access the data
        * There is still some exposure especially if we pass an object of a previous Transaction2 to create a new Transaction2 object
         */

    }


    /** @return a list of 12 monthly payments of identical amounts
     * This code will help demostrate the Design exposures still present in transaction3 class
     * */
    public static List<Transaction3> makeYearOfPayments (int amount) throws NullPointerException {

        List<Transaction3> listOfTransaction3s = new ArrayList<Transaction3>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);
        for (int i = 0; i < 12; i++) {
            listOfTransaction3s.add(new Transaction3(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction3s;
    }

    /*
    Testing Transaction3 class
     */
    public static void testTransaction3() {
        List<Transaction3> allPaymentsIn2024 = makeYearOfPayments(1000);
        for (Transaction3 t3 : allPaymentsIn2024) {
            // Display all the 12 Transactions
            for (Transaction3 transact : allPaymentsIn2024) {
                System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
                System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+transact.getAmount());
                System.out.println("Lecture1_adt.TransactionInterface Date: \t "+transact.getDate().getTime());
            }
        }

        /* Please Check all the 12 transactions displayed and hwo their dates look like
         * Note that Although Transaction3 class resolves to an extent the exposure in Transaction2 class
         * There is still some exposure especially if we pass an object of a previous Transaction3 to create a
         * new Transaction3 object
         */
    }


    /** @return a list of 12 monthly payments of identical amounts
     * This code Show that by judicious copying and defensive programming we eliminate the exposure in Transaction3
     * As defined in the constructor of Transaction4 class
     * */

    public static List<Transaction4> makeYearOfPaymentsFinal (int amount) throws NullPointerException {

        List<Transaction4> listOfTransaction4s = new ArrayList<Transaction4>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);

        for (int i = 0; i < 12; i++) {
            listOfTransaction4s.add(new Transaction4(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction4s;
    }

    /*
    Testing Transaction3 class
     */
    public static void testTransaction4() {
        List<Transaction4> transactionsIn2024 = makeYearOfPaymentsFinal(1200);
        for (Transaction4 transact : transactionsIn2024) {
            System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+transact.getAmount());
            System.out.println("Lecture1_adt.TransactionInterface Date: \t "+transact.getDate().getTime());
        }
    }
    // New method to test Withdrawal and Reversal Transactions with BankAccount
    public static void testWithdrawalAndReversal() {
        // Create a BankAccount with an initial balance of 5000
        BankAccount bankAccount = new BankAccount(5000);
        bankAccount.printBalance(); // Initial balance

        // Create and apply a standard withdrawal
        Calendar d1 = new GregorianCalendar();
        WithdrawalTransaction standardWithdrawal = new WithdrawalTransaction(1000, d1);
        standardWithdrawal.apply(bankAccount, "Standard Withdrawal");
        System.out.println("\nAfter Standard Withdrawal:");
        bankAccount.printBalance(); // Balance after standard withdrawal

        // Create and apply an ATM withdrawal
        WithdrawalTransaction atmWithdrawal = new WithdrawalTransaction(500, d1);
        atmWithdrawal.apply(bankAccount, "ATM Withdrawal");
        System.out.println("\nAfter ATM Withdrawal:");
        bankAccount.printBalance(); // Balance after ATM withdrawal

        // Create and apply an online withdrawal
        WithdrawalTransaction onlineWithdrawal = new WithdrawalTransaction(200, d1);
        onlineWithdrawal.apply(bankAccount, "Online Withdrawal");
        System.out.println("\nAfter Online Withdrawal:");
        bankAccount.printBalance(); // Balance after online withdrawal


        // Create a reversal of the withdrawal transaction
        ReversalTransaction reversal = standardWithdrawal.reverse(bankAccount);

        // Apply the reversal transaction to the account
        bankAccount.applyTransaction(reversal);
        System.out.println("\nAfter Reversal:");
        bankAccount.printBalance(); // Balance after reversal
    }


    public static void main(String[] args) {
        // This is the client code
        // Uncomment the following lines to test the class which you would like to test

        //testTransaction1();
        // testTransaction2()
        // testTransaction3()
        // testTransaction4()

        testWithdrawalAndReversal();
    }
}