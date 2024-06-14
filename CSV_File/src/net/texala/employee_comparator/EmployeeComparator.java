package net.texala.employee_comparator;

import java.util.Comparator;

import net.texala.employee_details.Employee;

public class EmployeeComparator implements Comparator<Employee> {

    private String sortBy;

    public EmployeeComparator(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Employee emp1, Employee emp2) {
        switch (sortBy) {
            case "empid":
                return Integer.compare(emp1.getEmpID(), emp2.getEmpID());
            case "firstname":
                return emp1.getFirstName().compareTo(emp2.getFirstName());
            case "lastname":
                return emp1.getLastName().compareTo(emp2.getLastName());
            case "department":
            	return emp1.getDepartment().compareTo(emp2.getDepartment());
            default:
                throw new IllegalArgumentException("Invalid sorting criteria: " + sortBy);
        }
    }
}
