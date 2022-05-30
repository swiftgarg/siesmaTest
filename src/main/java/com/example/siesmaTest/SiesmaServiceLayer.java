package com.example.siesmaTest;

import java.util.ArrayList;

public class SiesmaServiceLayer {

    public void calculateEmployeeTax(ArrayList<Employee> emps){
        SiesmaBusinessLogicLayer siesmaBusinessLogicLayerObj = new SiesmaBusinessLogicLayer();
        for (Employee emp: emps
        ) {
            siesmaBusinessLogicLayerObj.calculateAnnualIncomeTaxOfEmployee(emp);
        }

    }
}
