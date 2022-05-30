package com.example.siesmaTest;

import java.util.ArrayList;

public class SiesmaServiceLayer {

    public void calculateEmployeeTax(ArrayList<Employee> emps){

        ArrayList<TaxSlabPOJO> taxSlabs = new ArrayList<TaxSlabPOJO>();
        taxSlabs.add(new TaxSlabPOJO(0,18200,0,0));
        taxSlabs.add(new TaxSlabPOJO(18201,37000,0.19,0));
        taxSlabs.add(new TaxSlabPOJO(37001,87000,0.325,3572));
        taxSlabs.add(new TaxSlabPOJO(87001,180000,0.37,19822));
        taxSlabs.add(new TaxSlabPOJO(180001,Double.MAX_VALUE,0.45,54232));

        SiesmaBusinessLogicLayer siesmaBusinessLogicLayerObj = new SiesmaBusinessLogicLayer();
        for (Employee emp: emps
        ) {
           // siesmaBusinessLogicLayerObj.calculateIncomeTaxOfEmployee(emp);
            siesmaBusinessLogicLayerObj.calculateTaxOfEmployee(emp, taxSlabs);
        }

    }
}
