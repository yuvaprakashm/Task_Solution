/*
DAY : 7
ASSIGNMENT NO : 2

Write a program called WordGuess to guess a word by trying to guess the
individual characters. The word to be guessed shall be provided using the
command-line argument. Your program shall look like as given below.''
Java WordGuess testing
Key in one character or your guess word: t
Trail 1: t__t___
Key in one character or your guess word: g
Trail 2: t__t__g
Key in one character or your guess word: e
Trail 3: te_t__g
Key in one character or your guess word: testing
Trail 4: Congratulation!
You got in 4 trials

*/
package net.texala.main;

import java.util.Scanner;

public class WordGuess {
    public static void main(String[] args) {
        String secretWord;

        if (args.length == 1) {
            secretWord = args[0].toLowerCase();
        } else {
            System.out.println("Usage: java WordGuess <word_to_guess>");
            return;
        }

        boolean[] guessedCharacters = new boolean[secretWord.length()];
        int trials = 0;
        boolean guessedWord = false;

        try (Scanner scanner = new Scanner(System.in)) {
            while (!allCharactersGuessed(guessedCharacters) && !guessedWord) {
                System.out.print("Key in one character or your guess word: ");
                String userInput = scanner.nextLine().toLowerCase();

                if (userInput.length() == 1 && Character.isLetter(userInput.charAt(0))) {
                    char guessedChar = userInput.charAt(0);
                    trials++;

                    if (secretWord.indexOf(guessedChar) != -1) {
                        updateGuessedCharacters(secretWord, guessedCharacters, guessedChar);
                    }

                    printTrialResult(secretWord, guessedCharacters, trials);
                } else if (userInput.equals(secretWord)) {
                    guessedWord = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid character or guess the entire word.");
                }
            }
        }

        if (allCharactersGuessed(guessedCharacters)) {
            System.out.println("Congratulations!");
            System.out.println("You got it in " + trials + " trials");
        }
    }

    private static boolean allCharactersGuessed(boolean[] guessedCharacters) {
        for (boolean guessed : guessedCharacters) {
            if (!guessed) {
                return false;
            }
        }
        return true;
    }

    private static void updateGuessedCharacters(String secretWord, boolean[] guessedCharacters, char guessedChar) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guessedChar) {
                guessedCharacters[i] = true;
            }
        }
    }

    private static void printTrialResult(String secretWord, boolean[] guessedCharacters, int trials) {
        System.out.print("Trail " + trials + ": ");
        for (int i = 0; i < secretWord.length(); i++) {
            System.out.print(guessedCharacters[i] ? secretWord.charAt(i) : '_');
        }
        System.out.println();
    }
}
