package com.example.siesmaTest;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


import java.util.ArrayList;

@SpringBootTest
class SiesmaTestApplicationTests {

	SiesRestController restControllerForTest = new SiesRestController();

	public ArrayList<Employee> setDummyValuesForTest() {
		ArrayList<Employee> tempEmps = new ArrayList<Employee>();
		tempEmps.add(new Employee("David", "Rudd", 60050.0, 1, (float) 0.09));
		tempEmps.add(new Employee("Ryan", "Chen", 120000.0, 1, (float) 0.1));
	return tempEmps;
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
		Assertions.assertEquals(1000.0,employeesWithTax.get(1).getSuperannuation());

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

}
