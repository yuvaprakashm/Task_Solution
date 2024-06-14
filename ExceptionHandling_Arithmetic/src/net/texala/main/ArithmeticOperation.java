/*
 
DAY : 06
ASSIGNMENT NO : 3

Write a program which take two integers and an arithmetic operator from the
command line and performs the operation. Execute the following user defined
exceptions.
If the no. of arguments is less than 3, then throw
IllegalNumberOfArguments.
If the operator is not an Arithmetic operator, throw
InvalidOperatorException.
If result is negative, then throw NegativeResultException.

*/
package net.texala.main;

class IllegalNumberOfArguments extends Exception {
	public IllegalNumberOfArguments(String message) {
		super(message);
	}
}

class InvalidOperatorException extends Exception {
	public InvalidOperatorException(String message) {
		super(message);
	}
}

class NegativeResultException extends Exception {
	public NegativeResultException(String message) {
		super(message);
	}
}

public class ArithmeticOperation {
	public static void main(String[] args) {
		try {
			if (args.length < 3) {
				throw new IllegalNumberOfArguments("IllegalNumberOfArguments.");
			}

			int operand1 = Integer.parseInt(args[0]);
			int operand2 = Integer.parseInt(args[1]);
			String operator = args[2];

			int result = performOperation(operand1, operand2, operator);
			System.out.println("Result: " + result);
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid operand. Please enter valid integers.");
		} catch (IllegalNumberOfArguments | InvalidOperatorException | NegativeResultException
				| ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}

	private static int performOperation(int operand1, int operand2, String operator)
			throws InvalidOperatorException, NegativeResultException, ArithmeticException {
		int result = 0;

		switch (operator) {
		case "+":
			result = operand1 + operand2;
			break;
		case "-":
			result = operand1 - operand2;
			break;
		case "*":
			result = operand1 * operand2;
			break;

		case "/":
			if (operand2 != 0) {
				result = operand1 / operand2;
			} else {
				throw new ArithmeticException("Arithmetic Exception");
			}
			break;
		default:
			throw new InvalidOperatorException("InvalidOperatorException the Supported operators are +, -, *, /.");
		}

		if (result < 0) {
			throw new NegativeResultException("NegativeResultException");
		}

		return result;
	}
}
