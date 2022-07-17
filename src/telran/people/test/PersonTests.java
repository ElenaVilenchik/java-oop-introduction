package telran.people.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import telran.people.Employee;
import telran.people.Person;
import telran.people.SalesPerson;
import telran.people.WageEmployee;

class PersonTests {
	@Test
	void PersonsTest() {
		long id = 123456;
		int birthYear = 29061972;
		String email = "aa@fghj.com";
		Person person = new Person(id, birthYear, email);
		assertEquals(id, person.getId());
		assertEquals(birthYear, person.getBirthYear());
		assertEquals(email, person.getEmail());
		email = "dfhgdfhgh@google.com";
		person.setEmail(email);
		assertEquals(email, person.getEmail());
	}

	@Test
	void EmployeeTest() {
		long id = 123456;
		int birthYear = 29061972;
		String email = "aa@fghj.com";
		int basicSalary = 6000;
		Employee employee = new Employee(id, birthYear, email, basicSalary);
		employee.setBasicSalary(basicSalary);
		assertEquals(basicSalary, employee.computePay());
		basicSalary = 8000;
		employee.setBasicSalary(basicSalary);
		assertEquals(basicSalary, employee.computePay());
	}

	@Test
	void WageEmployeeTest() {
		long id = 123456;
		int birthYear = 29061972;
		String email = "aa@fghj.com";
		int basicSalary = 6000;
		int wage = 45;
		int hours = 2;
		WageEmployee wageEmployee = new WageEmployee(id, birthYear, email, basicSalary, wage, hours);
		wageEmployee.setWage(wage);
		wageEmployee.setHours(hours);
		assertEquals(basicSalary + wage * hours, wageEmployee.computePay());
		wage = 30;
		hours = 1;
		wageEmployee.setWage(wage);
		wageEmployee.setHours(hours);
		assertEquals(basicSalary + wage * hours, wageEmployee.computePay());
	}

	@Test
	void SalesPersonTest() {
		long id = 123456;
		int birthYear = 29061972;
		String email = "aa@fghj.com";
		int basicSalary = 1000;
		int sales = 1000;
		int percentPay = 5;
		SalesPerson salesPerson = new SalesPerson(id, birthYear, email, basicSalary, sales, percentPay);
		salesPerson.setSales(sales);
		salesPerson.setPersentPay(percentPay);
		assertEquals(basicSalary + Math.round(sales * percentPay / 100), salesPerson.computePay());
		sales = 1000;
		percentPay = 4;
		salesPerson.setSales(sales);
		salesPerson.setPersentPay(percentPay);
		assertEquals(basicSalary + Math.round(sales * percentPay / 100), salesPerson.computePay());
	}
}
