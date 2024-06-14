/*
DAY : 12
ASSIGNMENT NO :05

Create a java program if superclass is Serializable but you don’t want subclass to
be Serializable

*/
package net.texala.main;

import java.io.*;

public class NonSerializableSubclassExample {
	public static void main(String[] args) {

		Subclass obj = new Subclass("SuperFieldValue", "NonSerializableFieldValue");

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serializedObject.ser"))) {
			out.writeObject(obj); // writeobject() convert to object to stream
			System.out.println("Object serialized successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("serializedObject.ser"))) {
			Subclass deserializedObj = (Subclass) in.readObject();  //readObject() convert to stream to object
			System.out.println("Object deserialized successfully.");

			System.out.println("SuperField: " + deserializedObj.getSuperField());
			System.out.println("NonSerializableField: " + deserializedObj.getNonSerializableField());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
