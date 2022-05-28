package com.example.siesmaTest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SiesRestController {
   static final int[] SLAB_LIMIT_ARRAY = new int[]{0,18200,37000,87000,180000};
   static final double[] SLAB_TAX_ARRAY= new double[]{0,0.19,0.325,0.37,0.45};

   static final double[] SLAB_TAX_CONS = new double[]{0,0,3572,19822,54232};




    @RequestMapping(value = "/CalcTaxOfEmployees", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public double calculateTaxOfEmployees(@RequestBody ArrayList<Employee> emps) {



        for (Employee emp: emps
             ) {
                int j=4;
            while(emp.getAnnualSalary()> 0){

                if(emp.getAnnualSalary()>SLAB_LIMIT_ARRAY[j]){
                    emp.setIncomeTax(emp.getIncomeTax() + ((emp.getAnnualSalary()-SLAB_LIMIT_ARRAY[j])*SLAB_TAX_ARRAY[j]));

                    emp.setIncomeTax(emp.getIncomeTax() + SLAB_TAX_CONS[j]);
                    return emp.getIncomeTax();
                    } j--;
                }




            }





        return 0;
    }

}
