package net.texala.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;

		do {

			System.out.println("Enter the number of authors:");
			int numberOfAuthors = getValidIntInput(scanner);
			scanner.nextLine();
			Author[] authors = new Author[numberOfAuthors];

			for (int i = 0; i < numberOfAuthors; i++) {
				System.out.println("Enter Author details for Author " + (i + 1) + ":");
				authors[i] = getAuthorDetails(scanner);
			}

			System.out.println("\nEnter Book details:");
			System.out.print("Title: ");
			String bookTitle = scanner.nextLine();

			System.out.print("Price: $");
			double bookPrice = getValidDoubleInput(scanner);

			System.out.print("Quantity in Stock: ");
			int bookQtyInStock = getValidIntInput(scanner);

			Book book = new Book(bookTitle, authors, bookPrice, bookQtyInStock);

			book.printAuthors();

			System.out.println("\nBook Details:");
			System.out.println(book);

			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static Author getAuthorDetails(Scanner scanner) {
		System.out.print("Name: ");
		String authorName = getValidAlphabeticInput(scanner);

		System.out.print("Email: ");
		String authorEmail = getValidEmailInput(scanner);

		System.out.print("Gender (M/F): ");
		char authorGender = scanner.next().charAt(0);
		scanner.nextLine();
		return new Author(authorName, authorEmail, authorGender);
	}

	private static String getValidAlphabeticInput(Scanner scanner) {
		String input;
		do {
			input = scanner.nextLine();
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
