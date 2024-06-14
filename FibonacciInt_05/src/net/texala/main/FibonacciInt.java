/*

DAY : 04
ASSIGNMENT NO : 05

Write a FibonacciInt program to list all the Fibonacci numbers, which can be
expressed as an int (that is, 32-bit signed integer in the range of [-2147483648,
2147483647]). Output should look like the following.
F(0) = 1
F(1) = 1
F(2) = 2
...
F(45) = 1836311903
F(46) is out of the range of int


 */

package net.texala.main;

public class FibonacciInt {

	public static void main(String[] args) {
		int n = 0;
		System.out.println("The fibonacci series less than  Integer.MAX_VALUE = 2147483647 ");
		while (true) {
			try {
				int fibonacci = computeFibonacci(n);
				System.out.println("F(" + n + ") = " + fibonacci);
				n++;
			} catch (ArithmeticException e) {
				System.out.println("F(" + n + ") is out of the range of int");
				break;
			}
		}
	}

	private static int computeFibonacci(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Fibonacci is not defined for negative numbers");
		}

		if (n == 0 || n == 1) {
			return 1;
		}

		int a = 1;
		int b = 1;

		for (int i = 2; i <= n; i++) {
			int temp = a + b;
			if (b > 0 && temp < 0) {
				throw new ArithmeticException("Overflow occurred for F(" + (n + 1) + ")");
			}
			a = b;
			b = temp;
		}

		return b;
	}
}