package net.texala.employee.exceptions;

public class CommitEmployeeException extends Exception {
    public CommitEmployeeException() {
        super("Error occurred while committing changes.");
    }

    public CommitEmployeeException(String message) {
        super(message);
    }
}
