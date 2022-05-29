package com.example.siesmaTest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@RestController
public class SiesRestController {
   static final int[] SLAB_LIMIT_ARRAY = new int[]{0,18200,37000,87000,180000};
   static final double[] SLAB_TAX_ARRAY= new double[]{0,0.19,0.325,0.37,0.45};

   static final double[] SLAB_TAX_CONS = new double[]{0,0,3572,19822,54232};


/*@GetMapping("/helloyello")
public String helloWorld(){
    return "Hello Yello";
}*/


    @RequestMapping(value = "/CalcTaxOfEmployees", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ArrayList<Employee> calculateTaxOfEmployees(@RequestBody ArrayList<Employee> emps) {



        for (Employee emp: emps
             ) {
                int j=4;//Taking counter from the last index
            while(emp.getAnnualSalary()> 0){

                if(emp.getAnnualSalary()>SLAB_LIMIT_ARRAY[j]){// checking if salary is more than the limits on array starting with the max
                    //if salary is more than respective slab, we add the tax of percentage of reamining amount other than previous limit
                    emp.setIncomeTax(emp.getIncomeTax() + ((emp.getAnnualSalary()-SLAB_LIMIT_ARRAY[j])*SLAB_TAX_ARRAY[j]));
                    //and we simply add the tax slab constant for the passed slab by individual
                    emp.setIncomeTax(emp.getIncomeTax() + SLAB_TAX_CONS[j]);
                    //calculating gross by assuming payment Month gives us no of months we want salary of
                    emp.setGrossIncome(Math.round(emp.getPaymentMonth()*(emp.getAnnualSalary()/12)));
                    emp.setIncomeTax(Math.round((emp.getIncomeTax()/12)*emp.getPaymentMonth()));
                    emp.setNetIncome(Math.round(emp.getGrossIncome()-emp.getIncomeTax()));
                    emp.setSuperannuation(Math.round(emp.getGrossIncome()* emp.getSuperRate()));
                    //assuming we are generating payslips for current month, i have taken current month as 1st to calculate payslip
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
                    Date firstDayOfMonth = cal.getTime();
                    emp.setFromDate(firstDayOfMonth);
                    cal.set(Calendar.DATE, emp.getPaymentMonth()*cal.getActualMaximum(Calendar.DATE));//confirm i am multiplying the payment months with days what if feb
                    Date lastDayOfMonth = cal.getTime();
                    emp.setToDate(lastDayOfMonth);



                    break;
                    } j--;
                }




            }





        return emps;
    }

}
