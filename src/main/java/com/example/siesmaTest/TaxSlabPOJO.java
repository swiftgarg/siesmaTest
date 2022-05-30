package com.example.siesmaTest;

public class TaxSlabPOJO{
    private double slabMin;
    private double slabMax;
    private double unitTax;
    private double slabBaseTax;

    public TaxSlabPOJO(double slabMin, double slabMax, double unitTax, double slabBaseTax) {
        this.slabMin = slabMin;
        this.slabMax = slabMax;
        this.unitTax = unitTax;
        this.slabBaseTax = slabBaseTax;
    }

    public double getSlabBaseTax() {
        return slabBaseTax;
    }

    public void setSlabBaseTax(double slabBaseTax) {
        this.slabBaseTax = slabBaseTax;
    }

    public double getSlabMin() {
        return slabMin;
    }

    public void setSlabMin(double slabMin) {
        this.slabMin = slabMin;
    }

    public double getSlabMax() {
        return slabMax;
    }

    public void setSlabMax(double slabMax) {
        this.slabMax = slabMax;
    }

    public double getUnitTax() {
        return unitTax;
    }

    public void setUnitTax(double unitTax) {
        this.unitTax = unitTax;
    }


}
