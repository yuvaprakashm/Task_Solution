package net.texala.employee.factory;

import net.texala.employee.operation.AddEmployee;
import net.texala.employee.operation.CommitEmployee;
import net.texala.employee.operation.DeleteEmployee;
import net.texala.employee.operation.DisplayEmployee;
import net.texala.employee.operation.UpdateEmployee;
import net.texala.employee.service.EmployeeOperation;

public class EmployeeFactory {
    public EmployeeOperation createEmployeeOperation(int choice) {
        if (choice == 1) {
            return new AddEmployee();
        } else if (choice == 2) {
            return new UpdateEmployee();
        } else if (choice == 3) {
            return new DeleteEmployee();
        } else if (choice == 4) {
            return new DisplayEmployee();
        } else if (choice == 5) {
            return new CommitEmployee();
        } else {
            return null;
        }
    }
}
