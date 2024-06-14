/*
 
DAY : 7
ASSIGNMENT NO : 09
  
Write a program called PerfectPrimeFactorList that prompts the user
for an upper bound. The program shall display all the numbers (less than or
equal to the upper bound) that meets the above criteria. The output shall look
like as given below.
Enter the upper bound: 100
These numbers are equal to the product of prime factors:
1 6 10 14 15 21 22 26 30 33 34 35 38 39 42 46 51 55 57 58
62 65 66 69 70 74 77 78 82 85 86 87 91 93 94 95
[36 numbers found (36.00%)]


*/
package net.texala.main;

import java.util.Scanner;

public class PrimeFactors {

	public static void main(String[] args) {
		char userinput;
		do {

			System.out.print("Enter the upper bound (positive integer): ");
			Scanner in = new Scanner(System.in);
			if (!in.hasNextInt()) {
				System.out.println("Upper bound not valid. Please try again.");
				return;
			}
			int upperBound = in.nextInt();

			PrimeFactors aPerfectPrimeFactorList = new PrimeFactors();

			aPerfectPrimeFactorList.printPerfectPrimeFactors(upperBound);

			System.out.println("Do you want to run again ? (y/n) :");
			userinput = in.next().charAt(0);

		} while (userinput == 'y' || userinput == 'Y');
	}

	private boolean isPrime(int posInt) {
		for (int i = 2; i <= Math.sqrt(posInt); i++) {
			if (posInt % i != 0) {
				continue;
			}
			return false;
		}
		return true;
	}

	private boolean isProductOfPrimeFactors(int posInt) {
		int prod = 1;
		for (int i = 2; i < posInt; i++) {
			if (isPrime(i) && (posInt % i == 0))
				prod = prod * i;
		}
		return (prod == posInt);
	}

	private void printPerfectPrimeFactors(int upperBound) {
		System.out.println("These numbers are equal to the product of prime factors: ");

		int countProductOfPrimeFactors = 0;
		for (int i = 1; i <= upperBound; i++) {
			if (!isProductOfPrimeFactors(i)) {
				continue;
			}
			System.out.printf("%1$d ", i);
			countProductOfPrimeFactors++;
		}
		System.out.printf("\n[%1d numbers found (%2.2f%%)]\n", countProductOfPrimeFactors,
				((double) 100 * countProductOfPrimeFactors / upperBound));
	}

}
