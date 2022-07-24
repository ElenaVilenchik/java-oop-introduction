package telran.people.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import telran.people.Employee;
import telran.people.Person;
import telran.people.SalesPerson;
import telran.people.WageEmployee;

class PersonEmployeeTests {
	private static final long ID = 123;
	private static final int BIRTH_YEAR = 2000;
	private static final String EMAIL = "vasya@gmail.com";
	private static final String ANOTHER_EMAIL = "vasya@tel-ran.com";
	private static final int BASIC_SALARY = 10000;
	private static final int SALES = 50;
	private static final int PERCENT_PAY = 50;
	private static final int WAGE = 200;
	private static final int HOURS = 5;
	private static final int ANOTHER_BASIC_SALARY = 1000;
	private static final int ANOTHER_SALES = 500;
	private static final int ANOTHER_PERCENT_PAY = 10;
	private static final int ANOTHER_WAGE = 300;
	private static final int ANOTHER_HOURS = 20;

	@Test
	void PersonsTest() {
		Person person = new Person(ID, BIRTH_YEAR, EMAIL);
		/***************************************/
		// Person constructor and getters test
		assertEquals(ID, person.getId());
		assertEquals(BIRTH_YEAR, person.getBirthYear());
		assertEquals(EMAIL, person.getEmail());
		/***************************************/
		// Person setter test
		person.setEmail(ANOTHER_EMAIL);
		assertEquals(ANOTHER_EMAIL, person.getEmail());
	}

	@Test
	void EmployeeTest() {
		Employee employee = new Employee(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY);
		/***************************************/
		// Employee constructor test
		assertEquals(ID, employee.getId());
		assertEquals(BIRTH_YEAR, employee.getBirthYear());
		assertEquals(EMAIL, employee.getEmail());
		/******************************************************/
		// Employee computePay test
		assertEquals(BASIC_SALARY, employee.computePay());
		/***********************************************************/
		// Employee setter test
		employee.setBasicSalary(ANOTHER_BASIC_SALARY);
		assertEquals(ANOTHER_BASIC_SALARY, employee.computePay());
	}

	@Test
	void WageEmployeeTest() {
		WageEmployee wageEmployee = new WageEmployee(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY, WAGE, HOURS);
		/**********************************************/
		// WageEmployee constructor test
		assertEquals(ID, wageEmployee.getId());
		assertEquals(BIRTH_YEAR, wageEmployee.getBirthYear());
		assertEquals(EMAIL, wageEmployee.getEmail());
		/**********************************************/
		// WageEmployee computePay test
		assertEquals(BASIC_SALARY + WAGE * HOURS, wageEmployee.computePay());
		/***********************************************************/
		// WageEmployee setters test
		wageEmployee.setWage(ANOTHER_WAGE);
		wageEmployee.setHours(ANOTHER_HOURS);
		wageEmployee.setBasicSalary(ANOTHER_BASIC_SALARY);
		assertEquals(ANOTHER_BASIC_SALARY + ANOTHER_WAGE * ANOTHER_HOURS, wageEmployee.computePay());
	}

	@Test
	void SalesPersonTest() {
		SalesPerson salesPerson = new SalesPerson(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY, SALES, PERCENT_PAY);
		/**********************************************/
		// SalesPersone constructor test
		assertEquals(ID, salesPerson.getId());
		assertEquals(BIRTH_YEAR, salesPerson.getBirthYear());
		assertEquals(EMAIL, salesPerson.getEmail());
		/**********************************************/
		// SalesPersone computePay test
		assertEquals(Math.round(BASIC_SALARY + SALES / 100.0 * PERCENT_PAY), salesPerson.computePay());
		/***********************************************************/
		// SalesPerson setters test
		salesPerson.setSales(ANOTHER_SALES);
		salesPerson.setPercentPay(ANOTHER_PERCENT_PAY);
		salesPerson.setBasicSalary(ANOTHER_BASIC_SALARY);
		assertEquals(Math.round(ANOTHER_BASIC_SALARY + ANOTHER_SALES / 100.0 * ANOTHER_PERCENT_PAY),
				salesPerson.computePay());
	}

	@Test
	void wrongBirthYearTest() {
		boolean flException = false;
		try {
			new SalesPerson(123, 2018, ANOTHER_EMAIL, 1000, 100, 50);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(flException);
		try {
			new Employee(100, 1913, ANOTHER_EMAIL, BASIC_SALARY);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
	}

	@Test
	void wrongEmailTest() {
		boolean flException = false;
		try {
			new Person(ID, BIRTH_YEAR, "dfhdhgfjhfgjgfj");
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(flException);
		try {
			new Employee(ID, BIRTH_YEAR, "Abc.example.com", BASIC_SALARY);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(flException);
		try {
			new SalesPerson(ID, BIRTH_YEAR, "A@b@c@example.com", BASIC_SALARY, SALES, PERCENT_PAY);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(flException);
		try {
			new WageEmployee(ID, BIRTH_YEAR, "just\"not\"right@example.com", BASIC_SALARY, WAGE, HOURS);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
	}

	@Test
	void lowBasicSalaryTests() {
		boolean flException = false;
		try {
			new SalesPerson(ID, BIRTH_YEAR, ANOTHER_EMAIL, 60, SALES, PERCENT_PAY);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(flException);
		try {
			new WageEmployee(ID, BIRTH_YEAR, EMAIL, 80, WAGE, HOURS);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(flException);
		try {
			new Employee(ID, BIRTH_YEAR, ANOTHER_EMAIL, 90);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
	}

	@Test
	void wrongPercentPayTests() {
		boolean flException = false;
		try {
			new SalesPerson(ID, BIRTH_YEAR, ANOTHER_EMAIL, BASIC_SALARY, SALES, 110);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(flException);
		try {
			new SalesPerson(ID, BIRTH_YEAR, ANOTHER_EMAIL, BASIC_SALARY, SALES, -5);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
	}
}
