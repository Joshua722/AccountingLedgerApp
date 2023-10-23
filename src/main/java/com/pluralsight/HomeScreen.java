package com.pluralsight;

import java.util.*;
import java.io.*;
import java.time.*;


public class HomeScreen {
    static Scanner myScanner = new Scanner(System.in);


    public static void main(String[] args) {


    }

    public HomeScreen() throws IOException {
        int userChoice = myScanner.nextInt();
        do {
            System.out.println("Welcome to Stardust LLC! What can I help you with today?\n" +
                    "1) Add Deposit\n" +
                    "2) Display the Ledger Screen\n" +
                    "3) Make Payment\n" +
                    "4) Exit the application");
            userChoice = myScanner.nextInt();
            switch (userChoice) {
                case 1:
                    addDeposit();
                    break;
                case 2:
                    displayLedger();
                    break;
                case 3:
                    userPayment();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid option 1/2/3");
            }
        }
        while (userChoice != 4);

    }
}
