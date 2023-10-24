package com.pluralsight;

import java.io.*;
import java.util.Scanner;

import static com.pluralsight.HomeScreen.*;

public class DisplayLedger {
    static Scanner myScanner = new Scanner(System.in);

    public static void displayLedger() throws IOException {
        int userInput;
        System.out.println("What would you like to do?\n" +
                "1) Display all entries\n" +
                "2) Display only deposits\n" +
                "3) Display only payments\n" +
                "4) Go to a new screen to run pre defined reports or to run a custom search\n" +
                "5) Home");
        userInput = myScanner.nextInt();
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
        System.out.println("Here is the Report screen options" +
                "1) Month to Date\n" +
                "2) Previous Month\n" +
                "3) Year to Date\n" +
                "4) Previous Year\n" +
                "5) Search by Vendor\n" +
                "x) Exit back to report page\n" +
                "0) Home");



    }


}
