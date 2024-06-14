/*

DAY : 10
ASSIGNMENT NO :13

Create a class Account with two overloaded constructors. The first constructor is
used for initializing the name of the account holder, account number and the initial
amount in the account. The second constructor is used for initializing the name of the
account holder, the account number, the addresses, the type of account and the current
balance. The Account class is having methods Deposit (), Withdraw (), and Get_Balance(). 
Make the necessary assumption for data members and return
types of the methods. Create the objects of Account class and use them.


*/
package net.texala.main;

import java.util.Scanner;

public class Account {
	private double balance;

	public Account(String accountHolderName, long accountNumber, double initialAmount) {
		this.balance = initialAmount;
	}

	public Account(String accountHolderName, long accountNumber, String address, String accountType,
			double initialBalance) {
		this.balance = initialBalance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposit successful. Current balance: " + balance);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal successful. Current balance: " + balance);
		} else {
			System.out.println("Invalid withdrawal amount or insufficient funds.");
		}
	}

	public double getBalance() {
		return balance;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter account holder name for Account 1:");
		String accountHolderName1 = scanner.nextLine();

		System.out.println("Enter account number for account 1 :");
		long accountnumber1 = scanner.nextLong();

		System.out.println("Enter initial balance for Account 1:");
		double initialBalance1 = scanner.nextDouble();

		Account account1 = new Account(accountHolderName1, accountnumber1, initialBalance1);

		scanner.nextLine();

		System.out.println("Enter account holder name for Account 2:");
		String accountHolderName2 = scanner.nextLine();

		System.out.println("Enter account number for account 2 :");
		long accountnumber2 = scanner.nextLong();

		System.out.println("Enter initial balance for Account 2:");
		double initialBalance2 = scanner.nextDouble();

		Account account2 = new Account(accountHolderName2, accountnumber2, initialBalance2);

		System.out.println("Enter deposit amount for Account 1:");
		double depositAmount1 = scanner.nextDouble();
		account1.deposit(depositAmount1);

		System.out.println("Enter withdrawal amount for Account 2:");
		double withdrawalAmount2 = scanner.nextDouble();
		account2.withdraw(withdrawalAmount2);

		System.out.println("Account 1 balance: " + account1.getBalance());
		System.out.println("Account 2 balance: " + account2.getBalance());

		scanner.close();
	}
}
