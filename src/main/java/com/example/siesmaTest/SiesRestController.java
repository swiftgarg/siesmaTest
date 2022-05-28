package com.example.siesmaTest;

import java.util.ArrayList;

@RestController
public class SiesRestController {

    @RequestMapping(value = "/CalcTaxOfEmployees", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void calculateTaxOfEmployees(@RequestBody ArrayList<Employee> emps) {
        NavigableMap<Integer,Double> constantIncrease =
                new TreeMap<Integer, Double>();
        constantIncrease.put(37001,3572);
        constantIncrease.put(87001,19822);
        constantIncrease.put(180001,54232);
        NavigableMap<Integer,Double> percentIncrease =
                new TreeMap<Integer, Double>();
        percentIncrease.put(18201,0.19);
        percentIncrease.put(37001,0.325);
        percentIncrease.put(87001,0.37);
        percentIncrease.put(180001,0.45);






        for (Employee E : emps){
            E.taxDetails.setIncomeTax();

        }





    }

}
