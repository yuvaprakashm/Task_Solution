/*
 
 DAY : 09
 ASSIGNMENT NO : 05
 
1.Write a program in Java to handle the string and perform the following operation.
2.Read the contents of a file.
3.Write the contents in another file without repeating any character.
4.Also prints on console ? the number of occurrence of every character in the file.

*/

package net.texala.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileOperation {

	public static void main(String[] args) {
		String inputFile = "input.txt";
		String outputFile = "output.txt";

		try {

			String fileContents = readFromFile(inputFile);

			String uniqueContents = removeDuplicates(fileContents);
			writeToFile(outputFile, uniqueContents);

			printCharacterOccurrences(fileContents);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readFromFile(String fileName) throws IOException {
		StringBuilder content = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line).append("\n");
			}
		}

		return content.toString();
	}

	private static void writeToFile(String fileName, String content) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			bw.write(content);
		}
	}

	private static String removeDuplicates(String input) {
		StringBuilder result = new StringBuilder();
		Map<Character, Integer> charCountMap = new HashMap<>();

		for (char ch : input.toCharArray()) {
			if (!charCountMap.containsKey(ch)) {
				result.append(ch);
			}
			charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
		}

		return result.toString();
	}

	private static void printCharacterOccurrences(String input) {
		Map<Character, Integer> charCountMap = new HashMap<>();

		for (char ch : input.toCharArray()) {

			if (!Character.isWhitespace(ch)) {
				charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
			}
		}

		System.out.println("Character occurrences:");
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
