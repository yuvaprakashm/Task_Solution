/*

DAY : 04
ASSIGNMENT NO : 03

Write a method to compute sin(x) and cos(x) using the following series
expansion in a class called TrigonometricSeries. The headers of the methods
are as follows.


 */

package net.texala.main;

public class Trignometric {
	public static void main(String[] args) {
		double x = Math.PI / 6;
		int numTerms = 10;
		Trignometric aTrigonometricSeries = new Trignometric();
		System.out.println("Calculated values:");
		System.out.printf("sin(%d) = %.2f \n", (int) Math.round(x * 180 / Math.PI),
				aTrigonometricSeries.sin(x, numTerms)); // %d represents degree
		System.out.printf("cos(%d) = %.2f \n", (int) Math.round(x * 180 / Math.PI),
				aTrigonometricSeries.cos(x, numTerms)); // Math.round calculates the degree value

		System.out.println("java.lang.Math values:");
		System.out.printf("sin(%1$d) = %2$f \n", (int) Math.round(x * 180 / Math.PI), Math.sin(x));
		System.out.printf("cos(%1$d) = %2$f \n", (int) Math.round(x * 180 / Math.PI), Math.cos(x));
	}

	private double calculateTerm(double x, int numTerms) {
		double term = 1.0;
		for (int i = numTerms; i > 0; i--) {
			term = term * x / i;
		}
		return term;
	}

	private double sin(double x, int numTerms) {
		double result = 0.0;
		for (int i = 0; i < numTerms; i++) {
			if (i % 2 == 0) {
				result = result + calculateTerm(x, (2 * i + 1));
			} else {
				result = result - calculateTerm(x, (2 * i + 1));
			}

		}
		return result;
	}

	private double cos(double x, int numTerms) {
		double result = 0D;
		for (int i = 0; i < numTerms; i++) {
			if (i % 2 == 0) {
				result = result + calculateTerm(x, 2 * i);
			} else {
				result = result - calculateTerm(x, 2 * i);
			}

		}
		return result;
	}
}
