package net.texala.employee_service.generateobject;

import net.texala.employee_service.development.development;
import net.texala.employee_service.ps.ps;
import net.texala.employee_service.qa.qa;
import net.texala.employee_service.admin.admin;
import net.texala.interface_employee_service.Department;

public class DepartmentFactory {

	public Department createDepartment(int choice) {
		if (choice == 1) {
			return new development();
		} else if (choice == 2) {
			return new ps();
		} else if (choice == 3) {
			return new qa();
		} else if (choice == 4) {
			return new admin();
		} else {
			return null;
		}
	}
}
