package com.pluralsight;

import java.io.*;
import java.util.Scanner;
import java.time.*;

import static com.pluralsight.HomeScreen.*;

public class DisplayLedger {
    static Scanner myScanner = new Scanner(System.in);


    public static void displayLedger() throws IOException {
        Reader.Reader();
        int userInput;
        System.out.println("What would you like to do?\n" +
                "1) Display all entries\n" +
                "2) Display only deposits\n" +
                "3) Display only payments\n" +
                "4) Go to a new screen to run a pre defined search filters\n" +
                "5) Home");
        userInput = myScanner.nextInt();
        myScanner.nextLine();
        switch (userInput) {
            case 1:
                displayAll();
                break;
            case 2:
                displayDeposits();
                break;
            case 3:
                displayPayments();
                break;
            case 4:
                newReports();
                break;
            case 5:
                break;
        }


    }

    public static void displayAll() throws IOException {
        for (Ledger r : ledgerHashMap.values()) {
            System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                    r.getDate(), r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
        }

    }

    public static void displayDeposits() throws IOException {
        for (Ledger r : ledgerHashMap.values()) {
            if (r.getAmount() > 0) {
                System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                        r.getDate(), r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
            }
        }

    }

    public static void displayPayments() throws IOException {
        for (Ledger r : ledgerHashMap.values()) {
            if (r.getAmount() < 0) {
                System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                        r.getDate(), r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
            }
        }

    }

    public static void newReports() throws IOException {
        //creating variable to be used
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        YearMonth currentYearMonth = YearMonth.from(currentDate);
        YearMonth previousYearMonth = currentYearMonth.minusMonths(1);
        Year currentYear = Year.from(currentDate);
        Year previousYear = currentYear.minusYears(1);
        int userInput;
        String userChoice;
        System.out.println("Here is the Report screen options\n" +
                "1) Month to Date\n" +
                "2) Previous Month\n" +
                "3) Year to Date\n" +
                "4) Previous Year\n" +
                "5) Search by Vendor\n" +
                "6) Exit to Ledger Screen\n" +
                "0) Home");
        userInput = myScanner.nextInt();
        myScanner.nextLine();
        switch (userInput) {
            case 1:
                for (Ledger r : ledgerHashMap.values()) {
                    LocalDate transactionDate = r.getDate();
                    if (transactionDate.getMonth() == currentMonth) {
                        System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                transactionDate, r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                    }
                }
                break;
            case 2:
                for (Ledger r : ledgerHashMap.values()) {
                    //grabbing the month from transaction date that is grabbing it from the CSV file
                    LocalDate transactionDate = r.getDate();
                    YearMonth transactionYearMonth = YearMonth.from(transactionDate);
                    if (transactionYearMonth.equals(previousYearMonth)) {
                        System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                transactionDate, r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                    }
                }
                break;
            case 3:
                for (Ledger r : ledgerHashMap.values()) {
                    LocalDate transactionDate = r.getDate();
                    Year transactionYear = Year.from(transactionDate);
                    if (transactionYear.equals(currentYear)) {
                        System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                transactionDate, r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                    }
                }
                break;
            case 4:
                for (Ledger r : ledgerHashMap.values()) {
                    LocalDate transactionDate = r.getDate();
                    Year transactionYear = Year.from(transactionDate);
                    if (transactionYear.equals(previousYear)) {
                        System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                transactionDate, r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                    }
                }
                break;
            case 5:
                System.out.println("Please input the vendor");
                userChoice = myScanner.next();
                boolean foundMatch = false;
                for (Ledger r : ledgerHashMap.values()) {
                    String vendorChoice = r.getVendor();
                    if (vendorChoice.equalsIgnoreCase(userChoice)) {
                        System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                                r.getDate(), r.getTime(), r.getDescription(), r.getVendor(), r.getAmount());
                        foundMatch = true;
                    }
                }
                if (!foundMatch) {
                    System.out.println("That vendor is not listed in this file, if you would like to see all available options please view all transactions.");
                    System.out.println("Sending you back to Report Screen!");
                    newReports();
                }
                break;
            case 6:
                displayLedger();
                break;
            case 0:
                break;
            default:
                System.out.println("Please input a valid choice!");
                break;
        }
    }
}
