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
	private String accountHoldername;
	private long accountNumber;
	private String address;
	private String accountType;

	public Account(String accountHolderName, long accountNumber, double initialAmount) {
		this.balance = initialAmount;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account(String accountHolderName, long accountNumber, String address, String accountType,
			double initialBalance) {
		this.accountHoldername = accountHolderName;
		this.accountNumber = accountNumber;
		this.address = address;
		this.accountType = accountType;
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

}
