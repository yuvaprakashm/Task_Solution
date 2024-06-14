/*

DAY : 8
ASSIGNMENT NO : 07

Write a program in Java to add, update and delete the record of a Student from a
collection.
Student class contains name, id, course, and age. All the operation are done by user
on the command prompt. When user will commit, collection will be updated in
student.txt. Moreover, collection is stored in student.txt file.
© 2019


*/

package net.texala.main;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private int id;
	private String course;
	private int age;

	public Student(String name, int id, String course, int age) {
		this.name = name;
		this.id = id;
		this.course = course;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", ID: " + id + ", Course: " + course + ", Age: " + age;
	}
}