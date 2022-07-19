package telran.people.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import telran.people.Employee;
import telran.people.Person;
import telran.people.SalesPerson;
import telran.people.WageEmployee;

class PersonTests {
	private static final long ID = 123456;
	private static final int BIRTH_YEAR = 29061972;
	private static final String EMAIL = "aa@fghj.com";
	private static final String EMAIL_ANOTHER = "dfhgdfhgh@google.com";
	private static final int BASIC_SALARY = 6000;
	private static final int BASIC_SALARY_ANOTHER = 0;
	private static final int WAGE = 50;
	private static final int HOURS = 2;
	private static final int WAGE_ANOTHER = 30;
	private static final int HOURS_ANOTHER = 0;
	private static final int SALES = 1000;
	private static final int PERCENT_PAY = 5;
	private static final int SALES_ANOTHER = 90;
	private static final int PERCENT_PAY_ANOTHER = 4;

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
		person.setEmail(EMAIL_ANOTHER);
		assertEquals(EMAIL_ANOTHER, person.getEmail());
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
		employee.setBasicSalary(BASIC_SALARY_ANOTHER);
		assertEquals(BASIC_SALARY_ANOTHER, employee.computePay());
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
		wageEmployee.setWage(WAGE_ANOTHER);
		wageEmployee.setHours(HOURS_ANOTHER);
		wageEmployee.setBasicSalary(BASIC_SALARY_ANOTHER);
		assertEquals(BASIC_SALARY_ANOTHER + WAGE_ANOTHER * HOURS_ANOTHER, wageEmployee.computePay());
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
		salesPerson.setSales(SALES_ANOTHER);
		salesPerson.setPersentPay(PERCENT_PAY_ANOTHER);
		salesPerson.setBasicSalary(BASIC_SALARY_ANOTHER);
		assertEquals(Math.round(BASIC_SALARY_ANOTHER + SALES_ANOTHER / 100.0 * PERCENT_PAY_ANOTHER), salesPerson.computePay());
	}
}