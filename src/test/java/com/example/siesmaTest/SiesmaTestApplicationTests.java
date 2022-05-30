package com.example.siesmaTest;


import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.textract.model.transform.S3ObjectJsonUnmarshaller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class SiesmaTestApplicationTests {

	SiesRestController restControllerForTest = new SiesRestController();
	static final int[] SLAB_LIMIT_ARRAY = new int[]{0,18200,37000,87000,180000};
	static final double[] SLAB_TAX_ARRAY= new double[]{0,0.19,0.325,0.37,0.45};

	static final double[] SLAB_TAX_CONS = new double[]{0,0,3572,19822,54232};

	public ArrayList<Employee> setDummyValuesForTest() {
		ArrayList<Employee> tempEmps = new ArrayList<Employee>();
		tempEmps.add(new Employee("David", "Rudd", 60050.0, 1, (float) 0.09));
		tempEmps.add(new Employee("Ryan", "Chen", 120000.0, 1, (float) 0.1));
	return tempEmps;
	}

	SiesmaS3Connector siesmaS3Connector = new SiesmaS3Connector();

	@Test
	void testS3Connection() throws IOException {
		TaxSlabPOJO s3ObjectJsonUnmarshaller =  siesmaS3Connector.s3Connector();
		TaxSlabPOJO s3ObjectJsonUnmarshaller2 =  siesmaS3Connector.s3Connector();
		TaxSlabPOJO s3ObjectJsonUnmarshaller3 =  siesmaS3Connector.s3Connector();
		Assertions.assertEquals(s3ObjectJsonUnmarshaller,s3ObjectJsonUnmarshaller3);

	}


	@Test
	void testIncomeTaxCalculation(){
	ArrayList<Employee> employeesWithTax = new ArrayList<Employee>();
	employeesWithTax = restControllerForTest.calculateTaxOfEmployees(setDummyValuesForTest());
	Assertions.assertEquals(2669.0,employeesWithTax.get(1).getIncomeTax());

	}

	@Test
	void testNetIncomeCalculation(){
		ArrayList<Employee> employeesWithTax = new ArrayList<Employee>();
		employeesWithTax = restControllerForTest.calculateTaxOfEmployees(setDummyValuesForTest());
		Assertions.assertEquals(7331.0,employeesWithTax.get(1).getNetIncome());

	}

	@Test
	void testSuperannuationCalculation(){
		ArrayList<Employee> employeesWithTax = new ArrayList<Employee>();
		employeesWithTax = restControllerForTest.calculateTaxOfEmployees(setDummyValuesForTest());
		Assertions.assertEquals(1000.0,employeesWithTax.get(1).getSuperannuation());//asserting superannuation of user 2

	}

	@Test
	void testFirstName(){
		ArrayList<Employee> employeesWithTax = new ArrayList<Employee>();
		employeesWithTax = restControllerForTest.calculateTaxOfEmployees(setDummyValuesForTest());
		Assertions.assertEquals("Ryan",employeesWithTax.get(1).getFirstName());

	}
	@Test
	void testLastName(){
		ArrayList<Employee> employeesWithTax = new ArrayList<Employee>();
		employeesWithTax = restControllerForTest.calculateTaxOfEmployees(setDummyValuesForTest());
		Assertions.assertEquals("Chen",employeesWithTax.get(1).getLastName());

	}

	@Test
	void testOfTheTests(){
		ArrayList<Employee> employeesWithTax = new ArrayList<Employee>();
		ArrayList<Employee> employeesWithTaxNewCalc = new ArrayList<Employee>();
		employeesWithTaxNewCalc = newCalcToCalculateTaxOfEmployees(setDummyValuesForTest());
		employeesWithTax = restControllerForTest.calculateTaxOfEmployees(setDummyValuesForTest());
		Assertions.assertEquals(employeesWithTax.get(1).getIncomeTax(), employeesWithTaxNewCalc.get(1).getIncomeTax());

	}

	private ArrayList<Employee> newCalcToCalculateTaxOfEmployees(ArrayList<Employee> valuesForTest) {


		for (Employee emp : valuesForTest
		) {

			//another way to claculate same would be to start array from 1st index as here and trying to find the slab
			//which the individual passes
			int j = 0;
			while (emp.getAnnualSalary() > SLAB_LIMIT_ARRAY[j]) {
				j++;
			}
		if(SLAB_LIMIT_ARRAY[j-1]==0)//and we see if slab is 0, we set income tax as 0
				emp.setIncomeTax(0);
		else {//else we compute tax on money other than passed slab(which will be j-1 here)
			emp.setIncomeTax(emp.getIncomeTax() + ((emp.getAnnualSalary() - SLAB_LIMIT_ARRAY[j - 1]) * SLAB_TAX_ARRAY[j - 1]));
			emp.setIncomeTax(emp.getIncomeTax() + SLAB_TAX_CONS[j - 1]);//and adding constant tax slab of passed slab
		}



		emp.setGrossIncome(Math.round(emp.getPaymentMonth() * (emp.getAnnualSalary() / 12)));
		emp.setIncomeTax(Math.round((emp.getIncomeTax() / 12) * emp.getPaymentMonth()));
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

		return valuesForTest;

	}


}
