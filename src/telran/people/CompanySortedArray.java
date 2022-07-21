package telran.people;

import java.util.Arrays;

public class CompanySortedArray extends CompanyArray {

	@Override
	public boolean addEmployee(Employee empl) {
		Employee[] tmp = new Employee[employees.length + 1];
		int index = getEmployeeIndex(empl.getId());
		if (index < 0) {
			index = -(index) - 1;
			System.arraycopy(employees, 0, tmp, 0, index);
			tmp[index] = empl;
			System.arraycopy(employees, index, tmp, index + 1, employees.length - index);
			employees = tmp;
			return true;
		}
		return false;
	}

	@Override
	protected int getEmployeeIndex(long id) {
		return Arrays.binarySearch(employees, new Person(id, 0, null));
	}

	@Override
	public Employee[] getAllEmployees() {
		return Arrays.copyOf(employees, employees.length);
	}
}
