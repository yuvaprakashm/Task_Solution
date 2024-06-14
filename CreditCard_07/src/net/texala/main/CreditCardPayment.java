/*
  
DAY : 09
ASSIGNMENT NO: 07

Suppose, you owe the credit card company $1000.00. The company charges you
1.5% per month on the unpaid balance. You have decided to stop using the card and to
pay off the debt by making a monthly payment of N dollars a month. Write a program
that asks for the monthly payment and then write out the balance and total payments
received so far for every succeeding month until the balance is zero or less.
Output should be like as given below.
Enter the monthly payment.
100
Month 1: balance: 915.0 total payments: 100.0
Month 2: balance: 828.725 total payments: 200.0
Month 3: balance: 741.155875 total payments: 300.0
Month 4: balance: 652.273213125 total payments: 400.0
Month 5: balance: 562.057311321875 total payments: 500.0
Month 6: balance: 470.4881709917031 total payments: 600.0
Month 7: balance: 377.54549355657866 total payments: 700.0
Month 8: balance: 283.20867595992735 total payments: 800.0
Month 9: balance: 187.4568060993263 total payments: 900.0
Month 10: balance: 90.26865819081618 total payments: 1000.0
Month 11: balance: -8.377311936321576 total payments: 1100.0


*/
package net.texala.main;

import java.util.Scanner;

public class CreditCardPayment {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;

		do {
			try {
				System.out.print("Enter the initial amount: ");
				double initialAmount = scanner.nextDouble();

				System.out.print("Enter the monthly payment: ");
				double monthlyPayment = scanner.nextDouble();

				System.out.print("Enter the rate of interest per month: ");
				double interestRate = scanner.nextDouble();

				int month = 1;
				double totalPayments = 0;

				while (initialAmount > 0) {
					double interest = initialAmount * (interestRate / 100);
					initialAmount += interest;
					initialAmount -= monthlyPayment;

					totalPayments += monthlyPayment;

					System.out.printf("Month %d: balance: %.6f total payments: %.2f%n", month, initialAmount,
							totalPayments);

					if (initialAmount <= 0) {
						break;
					}

					month++;
				}

				System.out.print("Do you want to execute again (y/n)? : ");
				userinput = scanner.next().charAt(0);
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine();
				userinput = 'y';
			}

		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}
}
