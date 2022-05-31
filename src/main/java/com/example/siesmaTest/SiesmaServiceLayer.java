package com.example.siesmaTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SiesmaServiceLayer {

    public void calculateEmployeeTax(ArrayList<Employee> emps) throws IOException, ClassNotFoundException {

        SiesmaS3Connector siesmaS3Connector = new SiesmaS3Connector();
        SiesmaBusinessLogicLayer siesmaBusinessLogicLayerObj = new SiesmaBusinessLogicLayer();
        for (Employee emp: emps
        ) {
          siesmaBusinessLogicLayerObj.calculateTaxOfEmployee(emp, TaxSlabPOJO.serealizeTaxSlabs(siesmaS3Connector.s3Connector()));
        }

    }
}
