package com.example.siesmaTest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;


@RestController
public class SiesRestController {

    @RequestMapping(value = "/calcTaxOfEmployees", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ArrayList<Employee> calculateTaxOfEmployees(@RequestBody ArrayList<Employee> emps) throws IOException, ClassNotFoundException {
        SiesmaServiceLayer siesmaServiceLayerObj = new SiesmaServiceLayer();
        SiesmaS3Connector siesmaS3Connector = new SiesmaS3Connector();
        siesmaServiceLayerObj.calculateEmployeeTax(emps, TaxSlabPOJO.serealizeTaxSlabs(siesmaS3Connector.s3Connector()));
        return emps;
    }

}
