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
        siesmaServiceLayerObj.calculateEmployeeTax(emps);
        return emps;
    }

}
