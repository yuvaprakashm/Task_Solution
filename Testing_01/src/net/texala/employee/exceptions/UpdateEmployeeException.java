package net.texala.employee.exceptions;

public class UpdateEmployeeException extends Exception {
    public UpdateEmployeeException() {
        super("Error occurred while updating an employee.");
    }

    public UpdateEmployeeException(String message) {
        super(message);
    }
}
