package net.texala.employee.exceptions;

public class DeleteEmployeeException extends Exception {
    public DeleteEmployeeException() {
        super("Error occurred while deleting an employee.");
    }

    public DeleteEmployeeException(String message) {
        super(message);
    }
}
