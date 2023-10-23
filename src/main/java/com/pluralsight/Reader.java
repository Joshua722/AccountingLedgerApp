package com.pluralsight;

import java.io.*;
import java.util.Date;

public class Reader {

    public static void Reader() throws IOException {
        //create readers/writers
        String input;
        String date = "";
        String time = "";
        String description;
        String vendor;
        String userInput;
        double amount;
        Date formattedDate = null;
        Date formattedTime = null;
        FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while ((input = bufferedReader.readLine()) != null) {
            String[] transactionReader = input.split("\\|");
            if (!transactionReader[0].contains("date")) {
                String dateCSV = transactionReader[0];
                String timeCSV = transactionReader[1];
                String descriptionCSV = transactionReader[2];
                String vendorCSV = transactionReader[3];
                double amountCSV = Double.parseDouble(transactionReader[4]);
            }
        }
    }
}
