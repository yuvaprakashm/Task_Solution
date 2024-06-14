/*

DAY : 03
ASSIGNMENT NO : 07 

Write a program called GradesHistogram, which reads in n grades (of int
between 0 and 100, inclusive) from a text file called grades.in and displays the
histogram horizontally and vertically.

For example,
15
49 50 51 59 0 5 9 10 15 19 50 55 89 99 100


 */
package net.texala.main;

import java.io.*;
import java.util.Scanner;

public class GradeHistogram {

	private int[] grades;
	private int[] bins = new int[10];

	public static void main(String[] args) {
		GradeHistogram aGradesHistogram = new GradeHistogram();
		aGradesHistogram.readGrades("grades.in.txt");

		aGradesHistogram.computeHistogram();

		aGradesHistogram.printHistogramHorizontal();
		aGradesHistogram.printHistogramVertical();
	}

	private boolean isGradeValid(int grade) {
		return (0 <= grade && grade <= 100);
	}

	private void readGrades(String filename) {
		try {
			String filepath = getClass().getResource(filename).getPath();
			Scanner file = new Scanner(new File(filepath));

			if (!file.hasNextInt()) {
				System.out.println("Error! Not found students number.");
				return;
			}
			int n = file.nextInt();

			grades = new int[n];

			for (int i = 0; i < n; i++) {
				if (!file.hasNextInt()) {
					continue;
				}
				grades[i] = file.nextInt();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error! File \"grades.in\" not found.");
		}
	}

	private void computeHistogram() {
		for (int i = 0; i < grades.length; i++) {
			int j = (grades[i] == 100) ? 9 : grades[i] / 10;
			bins[j] += 1;
		}
	}

	private void printHistogramHorizontal() {
		System.out.println();
		for (int i = 0; i < bins.length; i++) {
			int delta = (i == bins.length - 1) ? 10 : 9;
			System.out.printf("%2d -%3d:", (i * 10), (i * 10 + delta));
			for (int j = 0; j < bins[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void printHistogramVertical() {

		int maxBin = bins[0];
		for (int i = 0; i < bins.length; i++) {
			maxBin = (bins[i] > maxBin) ? bins[i] : maxBin;
		}

		System.out.println();
		for (int i = maxBin; i >= 0; i--) {
			if (i == 0) {
				for (int j = 0; j < bins.length; j++) {
					int delta = (j == bins.length - 1) ? 10 : 9;
					System.out.printf("%2d-%-2d ", (j * 10), (j * 10 + delta));
				}
			} else {
				for (int j = 0; j < bins.length; j++) {
					String str = (bins[j] < i) ? " " : "*";
					System.out.printf("%3s%-2s ", str, " ");
				}
			}
			System.out.println();
		}
	}

	private void printGrades() {
		for (int i = 0; i < grades.length; i++) {
			System.out.print(grades[i] + " ");
		}
		System.out.println();
	}

	private void printBins() {
		for (int i = 0; i < bins.length; i++) {
			System.out.print(bins[i] + " ");
		}
		System.out.println();
	}
}