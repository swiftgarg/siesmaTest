package com.example.siesmaTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SiesmaBusinessLogicLayer {
    //Contains Business Logic
    public void calculateTaxOfEmployee(Employee emp, ArrayList<TaxSlabPOJO> taxSlabs){
        int slabCounter = 0;
        while(emp.getAnnualSalary()>taxSlabs.get(slabCounter).getSlabMax() && slabCounter<taxSlabs.size()){
            slabCounter++;
        }
        if(taxSlabs.get(slabCounter).getSlabMax()==0)//and we see if slab is 0, we set income tax as 0
            emp.setIncomeTax(0);
        else {//else we compute tax on money other than passed slab(which will be j-1 here)
            emp.setIncomeTax(emp.getIncomeTax() + ((emp.getAnnualSalary() - taxSlabs.get(slabCounter).getSlabMin()) * taxSlabs.get(slabCounter).getUnitTax()));
            emp.setIncomeTax(emp.getIncomeTax() + taxSlabs.get(slabCounter).getSlabBaseTax());//and adding constant tax slab of passed slab
        }

        emp.setGrossIncome(Math.round(emp.getPaymentMonth() * (emp.getAnnualSalary() / 12)));
        emp.setIncomeTax(Math.round((emp.getIncomeTax() / 12) * emp.getPaymentMonth()));//according to payment months
        emp.setNetIncome(Math.round(emp.getGrossIncome() - emp.getIncomeTax()));
        emp.setSuperannuation(Math.round(emp.getGrossIncome() * emp.getSuperRate()));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        Date firstDayOfMonth = cal.getTime();
        emp.setFromDate(firstDayOfMonth);
        cal.set(Calendar.DATE, emp.getPaymentMonth() * cal.getActualMaximum(Calendar.DATE));//confirm i am multiplying the payment months with days what if feb
        Date lastDayOfMonth = cal.getTime();
        emp.setToDate(lastDayOfMonth);

    }
}
