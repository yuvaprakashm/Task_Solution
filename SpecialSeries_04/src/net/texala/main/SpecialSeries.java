/*

DAY : 04
ASSIGNMENT NO : 04

Write a method to compute the sum of the series in a class called SpecialSeries.
The signature of the method is as follows.

 
 */

package net.texala.main;

import java.util.Scanner;

public class SpecialSeries {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		char userinput;
		do {
			System.out.println("Enter the value of x :");
			double x = scr.nextDouble();
			System.out.println("Enter the number of terms :");
			int numTerms = scr.nextInt();

			double result = sumOfSeries(x, numTerms);
			System.out.println("Sum of the series: " + result);
			System.out.println("Do you want to run again ? (y/n) :");
			userinput = scr.next().charAt(0);

		} while (userinput == 'y' || userinput == 'Y');
	}

	public static double sumOfSeries(double x, int numTerms) {
		double sum = 0.0;
		for (int i = 0; i < numTerms; i++) {
			double term = power(x, i);
			sum += term;
		}
		return sum;
	}

	public static double power(double x, int n) {
		double result = 1.0;
		for (int i = 0; i < n; i++) {
			result *= x;
		}
		return result;
	}
}