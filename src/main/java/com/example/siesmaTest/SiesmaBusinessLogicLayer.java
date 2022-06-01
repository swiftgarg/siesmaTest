package com.example.siesmaTest;

import java.util.*;

public class SiesmaBusinessLogicLayer {

    public void calculateTax(Employee emp, ArrayList<TaxSlabPOJO> taxSlabs, int incomeSlabOfEmployee) {

       double taxableSalaryInSlab = emp.getAnnualSalary() - taxSlabs.get(incomeSlabOfEmployee).getSlabMin();
       double taxOnSlab = taxSlabs.get(incomeSlabOfEmployee).getUnitTax();
       emp.setIncomeTax(emp.getIncomeTax() + taxableSalaryInSlab * taxOnSlab);
       double baseTaxOnSlab = taxSlabs.get(incomeSlabOfEmployee).getSlabBaseTax();
       //Add Slab's Base constant tax
        emp.setIncomeTax(emp.getIncomeTax() + baseTaxOnSlab);
    }


    //Contains Business Logic
    public void calculateTaxOfEmployee(Employee emp, ArrayList<TaxSlabPOJO> taxSlabs) {
        int incomeSlabOfEmployee = findIncomeSlabOfEmployee(emp, taxSlabs);

        calculateTax(emp, taxSlabs, incomeSlabOfEmployee);

        setEmployeeDetails(emp);
        Calendar cal = Calendar.getInstance();
        emp.setFromDate(getFirstDayMonMonth(cal));
        emp.setToDate(getLastDayMonMonth(cal));
    }


    public int findIncomeSlabOfEmployee(Employee emp, ArrayList<TaxSlabPOJO> taxSlabs) {
        int incomeSlabOfEmployee = 0; //Starting from first tax slab
        while (emp.getAnnualSalary() > taxSlabs.get(incomeSlabOfEmployee).getSlabMax() && incomeSlabOfEmployee < taxSlabs.size()) {
            incomeSlabOfEmployee++;
        }
        return incomeSlabOfEmployee;
    }


    void setEmployeeDetails(Employee emp) {
        emp.setGrossIncome(Math.round(emp.getPaymentMonth() * (emp.getAnnualSalary() / 12)));
        emp.setIncomeTax(Math.round((emp.getIncomeTax() / 12) * emp.getPaymentMonth()));//according to payment months
        emp.setNetIncome(Math.round(emp.getGrossIncome() - emp.getIncomeTax()));
        emp.setSuperannuation(Math.round(emp.getGrossIncome() * emp.getSuperRate()));
    }

    public Date getFirstDayMonMonth(Calendar cal) {
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        return cal.getTime();
    }

    public Date getLastDayMonMonth(Calendar cal) {
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        return cal.getTime();
    }

}
