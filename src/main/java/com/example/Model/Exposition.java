package com.example.Model;

import java.text.DateFormat;

public class Exposition {
    private String name;
    private DateFormat startDate;
    private DateFormat endDate;
    private String address;
    private int visitorsMax;

    public Exposition (String name, DateFormat startDate, DateFormat endDate, String address, int visitorsMax) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.visitorsMax = visitorsMax;
    }

    public String getName() {
        return this.name;
    }

    public DateFormat getStartDate() {
        return this.startDate;
    }

    public DateFormat getEndDate() {
        return this.endDate;
    }

    public String getAddress() {
        return this.address;
    }

    public int getVisitorsMax() {
        return this.visitorsMax;
    }

    

}
