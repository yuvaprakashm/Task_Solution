package net.texala.employee.exceptions;

public class DisplayEmployeeException extends Exception {
    public DisplayEmployeeException() {
        super("Error occurred while displaying employee information.");
    }

    public DisplayEmployeeException(String message) {
        super(message);
    }
}
