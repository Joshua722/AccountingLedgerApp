package com.pluralsight;

import java.util.*;
import java.io.*;
import java.time.*;

public class Ledger {
    //created private data
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    public Ledger(String date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;


    }
    public String getDate(){
        return this.date;
    }
    public String getTime(){
        return this.time;
    }
    public String getDescription(){
        return this.description;
    }
    public String getVendor(){
        return this.vendor;
    }
    public double getAmount(){
        return this.amount;
    }
    //for when I need to print out full list of (x) transaction
    @Override
        public String toString(){
        return this.getDate() + "|" + this.getTime() + "|" + this.getDescription() + "|" + this.getVendor() + "|" + this.getAmount();
    }
}
