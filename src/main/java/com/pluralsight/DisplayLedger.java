package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.time.*;

import static com.pluralsight.HomeScreen.*;

public class DisplayLedger {
    public static LocalDate currentDate = LocalDate.now();
    public static Month currentMonth = currentDate.getMonth(); //grabs month from locale date
    public static YearMonth currentYearMonth = YearMonth.from(currentDate); // grabs year and month from local date
    public static YearMonth previousYearMonth = currentYearMonth.minusMonths(1); // current month minus -1
    public static Year currentYear = Year.from(currentDate); //grabs year from local date
    public static Year previousYear = currentYear.minusYears(1); // grabs year of local time and minus 1 which gives you year before

    public static void displayLedger() throws IOException {
        //call reader again, it refreshes previous data from HomeScreen inputs
        Reader.fileReader();
        String userInput;
        do {
            System.out.println("""
                    What would you like to do?
                    1) Display all entries
                    2) Display only deposits
                    3) Display only payments
                    4) Go to a new screen to run pre defined search filters
                    5) Home""");
            userInput = myScanner.next().trim();
            myScanner.nextLine();
            //applied high order function
            switch (userInput) {
                case "1":
                    displayAll(ledgerListByDate(ledgerList)); //passing ledgerList as a parameter to the ledgerListByDate
                    break;
                case "2":
                    displayDeposits(ledgerListByDate(ledgerList));
                    break;
                case "3":
                    displayPayments(ledgerListByDate(ledgerList));
                    break;
                case "4":
                    newReports(ledgerListByDate(ledgerList));
                    break;
                case "5":
                    homeScreen();
                    break;
                default:
                    System.out.println("Please choose valid input");
                    break;
            }
        } while (!userInput.equals("5"));
    }

    //create new method that will organize all data from newest to oldest that can be used be anywhere
    public static ArrayList<Ledger> ledgerListByDate(ArrayList<Ledger> ledgerList) {
        // Sort the list in descending order based off date/time
        //.sort retrieve data from ledgerList then compares them to each other and puts newer one first
        //r is being assigned to the first object in Ledger(first line in ledgerList)
        //in this case r1 is first object and r2 is second object (lambda expression)
        ledgerList.sort((r1, r2) -> {
            LocalDateTime dateTime1 = LocalDateTime.of(r1.getDate(), r1.getTime());
            LocalDateTime dateTime2 = LocalDateTime.of(r2.getDate(), r2.getTime());
            return dateTime2.compareTo(dateTime1);
        });
        return ledgerList;
    }

    public static void displayAll(ArrayList<Ledger> ledgerList) {
        for (Ledger r : ledgerList) {
            System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                    r.getDate(), r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
        }
    }

    public static void displayDeposits(ArrayList<Ledger> ledgerList) {
        for (Ledger r : ledgerList) {
            if (r.getAmount() > 0) {
                System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                        r.getDate(), r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
            }
        }
    }

    public static void displayPayments(ArrayList<Ledger> ledgerList) {
        for (Ledger r : ledgerList) {
            if (r.getAmount() < 0) {
                System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                        r.getDate(), r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
            }
        }
    }

    public static void newReports(ArrayList<Ledger> ledgerList) throws IOException {
        String userInput;
        String userChoice;
        do {
            System.out.println(""" 
                    Here are the Report screen options
                    1) Month to Date
                    2) Previous Month
                    3) Year to Date
                    4) Previous Year
                    5) Search by Vendor
                    6) Exit to Ledger Screen
                    0) Home""");
            userInput = myScanner.nextLine();
            switch (userInput) {
                case "1":
                    for (Ledger r : ledgerList) {
                        //this is getting the date from value in hashmap and comparing it to the current local time
                        LocalDate transactionDate = r.getDate();
                        Year transactionYear = Year.from(transactionDate);
                        Month transactionMonth = transactionDate.getMonth();
                        if (transactionYear.equals(currentYear) && transactionMonth.equals(currentMonth)) {
                            System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                    transactionDate, r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                        }
                    }
                    break;
                case "2":
                    for (Ledger r : ledgerList) {
                        //grabbing the month from transaction date that is grabbing it from the Ledger objects
                        LocalDate transactionDate = r.getDate();
                        YearMonth transactionYearMonth = YearMonth.from(transactionDate);
                        if (transactionYearMonth.equals(previousYearMonth)) {
                            System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                    transactionDate, r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                        }
                    }
                    break;
                case "3":
                    for (Ledger r : ledgerList) {
                        LocalDate transactionDate = r.getDate();
                        Year transactionYear = Year.from(transactionDate);
                        if (transactionYear.equals(currentYear)) {
                            System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                    transactionDate, r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                        }
                    }
                    break;
                case "4":
                    for (Ledger r : ledgerList) {
                        LocalDate transactionDate = r.getDate();
                        Year transactionYear = Year.from(transactionDate);
                        if (transactionYear.equals(previousYear)) {
                            System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                    transactionDate, r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                        }
                    }
                    break;
                case "5":
                    System.out.println("Please input the vendor");
                    userChoice = myScanner.nextLine().trim();
                    boolean foundMatch = false;
                    //setting the foundMatch to false before for loop so that if it meets condition it can change it
                    //then if not it will remain false and proceed
                    for (Ledger r : ledgerList) {
                        String vendorChoice = r.getVendor();
                        if (vendorChoice.equalsIgnoreCase(userChoice)) {
                            System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                    r.getDate(), r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                            foundMatch = true;
                        }
                    }
                    if (!foundMatch) {
                        System.out.println("That vendor is not listed in this file, if you would like to see all" +
                                " available options please view all transactions.");
                        System.out.println("Sending you back to Report Screen!");
                    }
                    break;
                case "6":
                    displayLedger();
                    break;
                case "0":
                    homeScreen();
                    break;
                default:
                    System.out.println("Please input a valid choice!");
                    break;
            }
        } while (!userInput.equals("0"));
    }
}
