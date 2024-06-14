/*
 
DAY : 8
ASSIGNMENT NO : 4
    
Assuming that a text file named input1.txt already contains some text, write a function
named removeWordStartWithVowel() and writeFile().Create a new file and
remove those words whose first character starts with a vowel.
For example,
Input file contains Carry umbrella and Overcoat when it rains.
Output file contains Carry when it rains.
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
import java.util.StringTokenizer;

public class TextFileProcessor {
	public static void main(String[] args) {
		try {

			removeWordStartWithVowel("input1.txt", "output1.txt");

			System.out.println("Processing completed. Check the output file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void removeWordStartWithVowel(String inputFileName, String outputFileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

		String line;
		while ((line = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(line);
			StringBuilder modifiedLine = new StringBuilder();

			while (tokenizer.hasMoreTokens()) {
				String word = tokenizer.nextToken();

				if (!isVowel(word.charAt(0))) {
					modifiedLine.append(word).append(" ");
				}
			}

			writer.write(modifiedLine.toString().trim());
			writer.newLine();
		}

		reader.close();
		writer.close();
	}

	private static boolean isVowel(char c) {
		return "AEIOUaeiou".indexOf(c) != -1;
	}
}
