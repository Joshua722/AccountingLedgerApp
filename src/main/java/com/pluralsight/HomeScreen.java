package com.pluralsight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

import static com.pluralsight.DisplayLedger.displayLedger;


public class HomeScreen {
    //created global variables to use in other classes and methods
    static Scanner myScanner = new Scanner(System.in);
    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
    static int transactionId = 0;
    public static HashMap<Integer, Ledger> ledgerHashMap = new HashMap<Integer, Ledger>();
    Reader reader = new Reader();

    public static void homeScreen() throws IOException {
        int userChoice;

        do {
            System.out.println("Welcome to Stardust LLC! What can I help you with today?\n" +
                    "1) Add Deposit\n" +
                    "2) Display the Ledger Screen\n" +
                    "3) Make Payment\n" +
                    "4) Exit the application ");
            userChoice = myScanner.nextInt();
            myScanner.nextLine();
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
                    System.out.println("Please enter a valid option 1/2/3 ");
            }
        }
        while (userChoice != 4);

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
            String date = String.valueOf(LocalDate.now());
            String time = fmt.format(LocalTime.now());
            //write into csv file
            bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + "$" + amount + "\n");
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
            amount *= -1; //converts amount into a negative amount since it is a payment
            myScanner.nextLine();
            //format local dates
            String date = String.valueOf(LocalDate.now());
            String time = fmt.format(LocalTime.now());
            //write into csv file
            bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + "$" + amount + "\n");
            System.out.println("Payments has been recorded, Enter another payment? Yes or No? ");
            String userInput = myScanner.next().trim().toLowerCase();
            if (!userInput.equals("yes")) {
                break;
            }
        }

        bufferedWriter.close();

    }

    public static void transactionLog() throws IOException {
        //create variables
        String input;
        LocalDate dateCSV;
        LocalTime timeCSV;
        String descriptionCSV;
        String vendorCSV;
        double amountCSV;
        //create readers/writers
        FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while ((input = bufferedReader.readLine()) != null) {
            String[] transactionReader = input.split("\\|");
            if (!transactionReader[0].equals("date")) {
                dateCSV = LocalDate.parse(transactionReader[0]);
                timeCSV = LocalTime.parse(transactionReader[1]);
                descriptionCSV = transactionReader[2];
                vendorCSV = transactionReader[3];
                amountCSV = Double.parseDouble(transactionReader[4]);
                //store details into hashmap
                ledgerHashMap.put(transactionId, new Ledger(dateCSV, timeCSV, descriptionCSV, vendorCSV, amountCSV));
                transactionId++;
            }
        }
        fileReader.close();
    }

}

