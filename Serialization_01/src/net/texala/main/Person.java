/*

DAY : 12
ASSIGNMENT NO : 01

Serialization
Following are the steps for Serialization.
1.Create a Person class
2.Create SerializeMain.java in src
Deserialization
Following are the steps for Deserialization.
1.Create DeserializeMain.java in src

*/

package net.texala.main;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person name : " + name + ", age : " + age;
	}
}
