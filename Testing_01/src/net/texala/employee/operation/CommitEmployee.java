package net.texala.employee.operation;

import java.util.Scanner;
import net.texala.employee.service.EmployeeOperation;
import net.texala.employee.manager.EmployeeManager;

public class CommitEmployee implements EmployeeOperation {
    @Override
    public void execute(EmployeeManager manager, Scanner scanner) {
        manager.commitChanges();
    }
}
