/*

DAY :10
ASSIGNMENT NO:03

Create an Author class as described below. 
Create another class name Book which has one author associated with it.
Create objects of the Author and book and print the book detail.

*/
package net.texala.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;

		do {
			System.out.println("Enter Author details:");

			String authorName = getValidAlphabeticInput(scanner);

			System.out.print("Email: ");
			String authorEmail = getValidEmailInput(scanner);

			System.out.print("Gender (M/F): ");
			char authorGender = scanner.next().charAt(0);

			Author author = new Author(authorName, authorEmail, authorGender);

			scanner.nextLine();

			System.out.println("\nEnter Book details:");
			System.out.print("Title: ");
			String bookTitle = scanner.nextLine();

			System.out.print("Price: $");
			double bookPrice = getValidDoubleInput(scanner);

			System.out.print("Quantity in Stock: ");
			int bookQtyInStock = getValidIntInput(scanner);

			Book book = new Book(bookTitle, author, bookPrice, bookQtyInStock);

			System.out.println("\nBook Details:");
			System.out.println("Title: " + book.getName());
			System.out.println("Author: " + book.getAuthor().getName());
			System.out.println("Author Email: " + book.getAuthor().getEmail());
			System.out.println("Price: $" + book.getPrice());
			System.out.println("Quantity in Stock: " + book.getQtyInStock());

			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();

		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static String getValidAlphabeticInput(Scanner scanner) {
		String input;

		do {
			System.out.println("Name: ");
			input = scanner.nextLine().trim();
			if (!input.matches("[a-zA-Z]+")) {
				System.out.println("Invalid input. Please enter alphabets only.");
			}
		} while (!input.matches("[a-zA-Z]+"));
		return input;
	}

	private static String getValidEmailInput(Scanner scanner) {
		String input;
		do {
			input = scanner.nextLine();
			if (!input.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
				System.out.println("Invalid email format. Please enter a valid email address.");
			}
		} while (!input.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));
		return input;
	}

	private static double getValidDoubleInput(Scanner scanner) {
		while (!scanner.hasNextDouble()) {
			System.out.println("Invalid input. Please enter a valid number.");
			scanner.next();
		}
		return scanner.nextDouble();
	}

	private static int getValidIntInput(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter a valid integer.");
			scanner.next();
		}
		return scanner.nextInt();
	}
}
