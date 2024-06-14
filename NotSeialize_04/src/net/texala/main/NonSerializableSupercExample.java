/*
DAY :12
ASSIGNMENT NO : 04

Create a java program if superclass is not Serializable?

*/
package net.texala.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NonSerializableSupercExample {
	public static void main(String[] args) {

		Subclass obj = new Subclass("NonSerializableFieldValue", "SerializableFieldValue");

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serializedObject.ser"))) {
			out.writeObject(obj);
			System.out.println("Object serialized successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("serializedObject.ser"))) {
			Subclass deserializedObj = (Subclass) in.readObject();
			System.out.println("Object deserialized successfully.");

			System.out.println("NonSerializableField: " + deserializedObj.getNonSerializableField());
			System.out.println("SerializableField: " + deserializedObj.getSerializableField());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}