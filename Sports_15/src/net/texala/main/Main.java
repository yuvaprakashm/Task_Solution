/*

DAY : 10

ASSIGNMENT NO : 15

Write a program in Java to create a Player class. Inherit the classes as,
Cricket _Player, Football _Player and Hockey_ Player from Player class

*/
package net.texala.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		CricketPlayer cricketPlayer = null;
		FootballPlayer footballPlayer = null;
		HockeyPlayer hockeyPlayer = null;

		System.out.println("Enter Cricket Player's name:");
		String cricketPlayerName = scanner.nextLine();
		int cricketPlayerJerseyNo = readJerseyNumber(scanner);

		if (isValidName(cricketPlayerName)) {
			cricketPlayer = new CricketPlayer(cricketPlayerName, cricketPlayerJerseyNo);
		} else {
			System.out.println("Invalid name. Please enter alphabetic characters only.");
		}

		System.out.println("Enter football Player's name:");
		String footballPlayerName = scanner.nextLine();
		int footballPlayerJerseyNo = readJerseyNumber(scanner);

		if (isValidName(footballPlayerName)) {
			footballPlayer = new FootballPlayer(footballPlayerName, footballPlayerJerseyNo);
		} else {
			System.out.println("Invalid name. Please enter alphabetic characters only.");
		}

		System.out.println("Enter hockey Player's name:");
		String hockeyPlayerName = scanner.nextLine();
		int hockeyPlayerJerseyNo = readJerseyNumber(scanner);

		if (isValidName(hockeyPlayerName)) {
			hockeyPlayer = new HockeyPlayer(hockeyPlayerName, hockeyPlayerJerseyNo);
		} else {
			System.out.println("Invalid name. Please enter alphabetic characters only.");
		}

		if (cricketPlayer != null && footballPlayer != null && hockeyPlayer != null) {
			cricketPlayer.play();
			footballPlayer.play();
			hockeyPlayer.play();
		}

		scanner.close();
	}

	private static int readJerseyNumber(Scanner scanner) {
		while (true) {
			System.out.println("Enter Jersey Number:");
			String input = scanner.nextLine();

			if (!input.isEmpty() && input.matches("\\d+")) {
				return Integer.parseInt(input);
			} else {
				System.out.println("Invalid input. Please enter a valid integer for the Jersey Number.");
			}
		}
	}

	private static boolean isValidName(String name) {
		return name.matches("[a-zA-Z]+");
	}
}
