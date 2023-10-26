package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

import static com.pluralsight.DisplayLedger.*;

public class HomeScreen {
    //created global variables to use in other classes and methods
    public static Scanner myScanner = new Scanner(System.in);
    public static DateTimeFormatter timeFMT = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static DateTimeFormatter dateFMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static int transactionId = 0;
    public static HashMap<Integer, Ledger> ledgerHashMap = new HashMap<Integer, Ledger>();
    public static ArrayList<Ledger> ledgerList = new ArrayList<>(ledgerHashMap.values());

    public static void homeScreen() throws IOException {
        String userChoice;
        do {
            System.out.println("""
                    Welcome to Stardust LLC! What can I help you with today?
                    1) Deposits
                    2) Display Ledger Screen
                    3) Payments
                    4) Exit the application""");
            userChoice = myScanner.next();
            myScanner.nextLine();
            switch (userChoice) {
                case "1":
                    addDeposit();
                    break;
                case "2":
                    displayLedger();
                    break;
                case "3":
                    userPayment();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid option 1/2/3/4 ");
            }
        }
        while (true);

    }

    public static void addDeposit() throws IOException {
        BufferedWriter bufferedWriter;
        bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
        //ask user for input then will log into file
        while (true) {
            System.out.println("Description of transaction? ");
            String description = myScanner.nextLine().trim();
            System.out.println("Vendor? ");
            String vendor = myScanner.nextLine().trim();
            System.out.println("Lastly what was the amount? ");
            double amount = myScanner.nextDouble();
            myScanner.nextLine();
            //format local dates
            String date = dateFMT.format(LocalDate.now());
            String time = timeFMT.format(LocalTime.now());
            //write into csv file
            bufferedWriter.newLine();
            bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
            System.out.println("Deposit has been recorded, Enter another deposit? Yes or No? ");
            String userInput = myScanner.next().trim().toLowerCase();
            if (!userInput.equals("yes")) {
                break;
            }
        }
        bufferedWriter.close();
    }

    public static void userPayment() throws IOException {
        BufferedWriter bufferedWriter;
        bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
        //ask user for input then will log into file
        while (true) {
            System.out.println("Description of transaction? ");
            String description = myScanner.nextLine().trim();
            System.out.println("Vendor? ");
            String vendor = myScanner.nextLine().trim();
            System.out.println("Lastly what was the amount? ");
            double amount = myScanner.nextDouble();
            myScanner.nextLine();
            amount *= -1; //converts amount into a negative amount since it is a payment
            //format local dates
            String date = dateFMT.format(LocalDate.now());
            String time = timeFMT.format(LocalTime.now());
            //write into csv file
            bufferedWriter.newLine();
            bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
            System.out.println("Payments has been recorded, Enter another payment? Yes or No? ");
            String userInput = myScanner.next().trim().toLowerCase();
            if (!userInput.equals("yes")) {
                break;
            }
        }
        bufferedWriter.close();
    }
}
