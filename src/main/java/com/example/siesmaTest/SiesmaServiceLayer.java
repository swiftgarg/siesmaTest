package com.example.siesmaTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SiesmaServiceLayer {

    public void calculateEmployeeTax(ArrayList<Employee> emps, ArrayList<TaxSlabPOJO> taxSlabsATO) throws IOException, ClassNotFoundException {



        SiesmaBusinessLogicLayer siesmaBusinessLogicLayerObj = new SiesmaBusinessLogicLayer();
        for (Employee emp: emps
        ) {
          siesmaBusinessLogicLayerObj.calculateTaxOfEmployee(emp, taxSlabsATO);
        }

    }
}
