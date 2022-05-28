package com.example.siesmaTest;

import java.util.Date;

public class TaxPOJO {
private Date fromDate;
private Date toDate;
private double grossIncome;
private double incomeTax;
private double superannuation;
private double netIncome;


    public TaxPOJO() {
        this.grossIncome = 0;
        this.incomeTax = 0;
        this.superannuation = 0;
        this.netIncome = 0;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getSuperannuation() {
        return superannuation;
    }

    public void setSuperannuation(double superannuation) {
        this.superannuation = superannuation;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }


}
