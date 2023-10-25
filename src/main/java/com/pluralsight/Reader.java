package com.pluralsight;

import java.time.*;
import java.io.*;
import java.util.ArrayList;

import static com.pluralsight.HomeScreen.*;

public class Reader {

    public static void Reader() throws IOException {
        ledgerHashMap.clear(); // clear hashmap so that it refreshes it constantly
        String input;
        LocalDate dateCSV;
        LocalTime timeCSV;
        String description;
        String vendor;
        double amount;
        //create readers
        FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((input = bufferedReader.readLine()) != null) {
            String[] transactionReader = input.split("\\|");
            if (!transactionReader[0].contains("date")) {
                dateCSV = LocalDate.parse(transactionReader[0]);
                timeCSV = LocalTime.parse(transactionReader[1]);
                String descriptionCSV = transactionReader[2];
                String vendorCSV = transactionReader[3];
                double amountCSV = Double.parseDouble(transactionReader[4]);
                //store details into hashmap
                ledgerHashMap.put(transactionId, new Ledger(dateCSV, timeCSV, descriptionCSV, vendorCSV, amountCSV));
                transactionId++;
                ledgerList = new ArrayList<>(ledgerHashMap.values());
            }
        }
        bufferedReader.close();
    }
}
