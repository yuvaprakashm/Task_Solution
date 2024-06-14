package net.texala.main;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Account account1 = null;
		Account account2 = null;

		char userChoice;
		do {
			System.out.println("\nMenu:");
			System.out.println("1. Enter Account Details");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Get Balance");
			System.out.println("5. Exit");
			System.out.print("Enter your choice (1-5): ");

			userChoice = scanner.next().charAt(0);
			scanner.nextLine();

			switch (userChoice) {
			case '1':
				System.out.println("\nEnter account details for Account 1:");
				account1 = enterAccountDetails(scanner);
				System.out.println("\nEnter account details for Account 2:");
				account2 = enterAccountDetails(scanner);
				break;
			case '2':
				depositAmount(scanner, account1, "Account 1");
				depositAmount(scanner, account2, "Account 2");
				break;
			case '3':
				withdrawAmount(scanner, account1, "Account 1");
				withdrawAmount(scanner, account2, "Account 2");
				break;
			case '4':
				getBalance(account1, "Account 1");
				getBalance(account2, "Account 2");
				break;
			case '5':
				System.out.println("Terminating the program. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 5.");
			}
		} while (userChoice != '5');

		scanner.close();
	}

	private static Account enterAccountDetails(Scanner scanner) {
		System.out.print("Enter account holder name: ");
		String accountHolderName = getValidAlphabeticInput(scanner);

		System.out.print("Enter account number: ");
		long accountNumber = getValidNumericInput(scanner);
		scanner.nextLine();

		System.out.print("Enter address: ");
		String address = scanner.nextLine();

		System.out.print("Enter account type (savings/current): ");
		String accountType = getValidAccountTypeInput(scanner);

		System.out.print("Enter initial balance: $");
		double initialBalance = getValidNumericInput(scanner);

		scanner.nextLine();
		return new Account(accountHolderName, accountNumber, address, accountType, initialBalance);
	}

	private static void depositAmount(Scanner scanner, Account account, String accountName) {
		char userinput;

		if (account != null) {
			System.out.print("Enter account (1 or 2) to deposit into: ");
			int accountNumber = scanner.nextInt();
			System.out.print("Enter deposit amount for " + accountName + ": $");
			double depositAmount = getValidNumericInput(scanner);
			account.deposit(depositAmount);
			System.out.println("Deposit successful. " + accountName + " balance: $" + account.getBalance());
		} else {
			System.out.println("Account details not entered.");
		}

	}

	private static void withdrawAmount(Scanner scanner, Account account, String accountName) {

		if (account != null) {
			System.out.print("Enter account (1 or 2) to withdraw from: ");
			int accountNumber = scanner.nextInt();
			System.out.print("Enter withdrawal amount for " + accountName + ": $");
			double withdrawalAmount = getValidNumericInput(scanner);
			account.withdraw(withdrawalAmount);
			System.out.println("Withdrawal successful. " + accountName + " balance: $" + account.getBalance());
		} else {
			System.out.println("Account details not entered.");
		}

	}

	private static void getBalance(Account account, String accountName) {

		if (account != null) {
			System.out.print("Enter account (1 or 2) to check balance: ");
			int accountNumber = scanner.nextInt();
			System.out.println(accountName + " balance: $" + account.getBalance());
		} else {
			System.out.println("Account details not entered.");
		}

	}

	private static String getValidAlphabeticInput(Scanner scanner) {
		String input;
		do {
			input = scanner.nextLine().trim();
			if (!input.matches("[a-zA-Z]+")) {
				System.out.println("Invalid input. Please enter alphabets only.");
			}
		} while (!input.matches("[a-zA-Z]+"));
		return input;
	}

	private static long getValidNumericInput(Scanner scanner) {
		while (!scanner.hasNextLong()) {
			System.out.println("Invalid input. Please enter a valid number.");
			scanner.next();
		}
		return scanner.nextLong();
	}

	private static String getValidAccountTypeInput(Scanner scanner) {
		String input;
		do {
			input = scanner.nextLine().trim().toLowerCase();
			if (!input.equals("savings") && !input.equals("current")) {
				System.out.println("Invalid account type. Please enter 'savings' or 'current'.");
			}
		} while (!input.equals("savings") && !input.equals("current"));
		return input;
	}
}
