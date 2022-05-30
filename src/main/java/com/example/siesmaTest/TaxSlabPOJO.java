package com.example.siesmaTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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




    public static ArrayList<TaxSlabPOJO> serealizeTaxSlabs(){
        Gson gson = new Gson();
        ArrayList<TaxSlabPOJO> outputList = null;
        Type listOfTaxSlabs = new TypeToken<ArrayList<TaxSlabPOJO>>() {}.getType();

        // Read Slab config from file
//        try (Reader reader = new FileReader(TaxSlabJSONPath)) {
//            // Convert JSON File to Java Object
//            outputList = gson.fromJson(reader, listOfTaxSlabs);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    String taxSlabsString = "[\n" +
            "  {\n" +
            "    \"slab-min\": 0,\n" +
            "    \"slab-max\": 18200,\n" +
            "    \"unit-tax\": 0,\n" +
            "    \"slab-base-tax\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"slab-min\": 18201,\n" +
            "    \"slab-max\": 37000,\n" +
            "    \"unit-tax\": 0.19,\n" +
            "    \"slab-base-tax\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"slab-min\": 37001,\n" +
            "    \"slab-max\": 87000,\n" +
            "    \"unit-tax\": 0.325,\n" +
            "    \"slab-base-tax\": 3572\n" +
            "  },\n" +
            "  {\n" +
            "    \"slab-min\": 87001,\n" +
            "    \"slab-max\": 180000,\n" +
            "    \"unit-tax\": 19822,\n" +
            "    \"slab-base-tax\": 0.37\n" +
            "  },\n" +
            "  {\n" +
            "    \"slab-min\": 180000,\n" +
            "    \"slab-max\": 1e500,\n" +
            "    \"unit-tax\": 0,\n" +
            "    \"slab-base-tax\": 0\n" +
            "  }\n" +
            "]";

        outputList = gson.fromJson(taxSlabsString, listOfTaxSlabs);
        assert(outputList != null);
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
