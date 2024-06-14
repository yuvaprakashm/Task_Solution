/*

DAY : 03
ASSIGNMENT NO : 10

Read student name and their grade from the hash file given below and also find the
highest grade of student and print the highest grade along with the student name.
{
“Student name” = {
1=”Sandeep”
2=”Deepak”
};
Student grade = {
1=80
2=85
}
};


 */
package net.texala.main;

import java.util.HashMap;
import java.util.Map;

public class HashTable {

	public static void main(String[] args) {

		Map<Integer, String> studentNames = new HashMap<>();
		studentNames.put(1, "Sandeep");
		studentNames.put(2, "Deepak");

		Map<Integer, Integer> studentGrades = new HashMap<>();
		studentGrades.put(1, 80);
		studentGrades.put(2, 85);

		Map<String, Integer> studentMap = new HashMap<>();

		System.out.println("Student Names and Grades:");
		for (Map.Entry<Integer, String> entry : studentNames.entrySet()) {
			int studentId = entry.getKey();
			String studentName = entry.getValue();
			int grade = studentGrades.get(studentId);

			studentMap.put(studentName, grade);

			System.out.println("Student ID: " + studentId);
			System.out.println("Name: " + studentName);
			System.out.println("Grade:" + grade);
		}

		Map.Entry<String, Integer> entryWithHighestGrade = null;
		for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
			if (entryWithHighestGrade == null || entry.getValue() > entryWithHighestGrade.getValue()) {
				entryWithHighestGrade = entry;
			}
		}

		System.out.println("\nStudent with the highest grade:");
		System.out.println("Student Name: " + entryWithHighestGrade.getKey());
		System.out.println("Highest Grade: " + entryWithHighestGrade.getValue());
	}
}
