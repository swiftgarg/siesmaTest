package com.example.siesmaTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;



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




    public static ArrayList<TaxSlabPOJO> serealizeTaxSlabs(String taxSlabsString){

        Gson gson = new Gson();
        ArrayList<TaxSlabPOJO> outputList = null;
        Type listOfTaxSlabs = new TypeToken<ArrayList<TaxSlabPOJO>>() {}.getType();

        outputList = gson.fromJson(taxSlabsString, listOfTaxSlabs);
        assert(outputList != null);
        outputList.get(outputList.size()-1).setSlabMax(Double.MAX_VALUE);
        return  outputList;
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
