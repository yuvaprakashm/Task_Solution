package net.texala.employee.exceptions;

public class AddEmployeeException extends Exception {
    public AddEmployeeException() {
        super("An error occurred while performing employee operation.");
    }

    public AddEmployeeException(String message) {
        super(message);
    }
}
