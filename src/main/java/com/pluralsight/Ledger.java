package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ledger {
    //created private data
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public Ledger(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public String getDescription() {
        return this.description;
    }

    public String getVendor() {
        return this.vendor;
    }

    public double getAmount() {
        return this.amount;
    }

}
