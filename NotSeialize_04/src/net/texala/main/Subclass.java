/*
DAY :12
ASSIGNMENT NO : 04

Create a java program if superclass is not Serializable?

*/
package net.texala.main;  //we can serialize subclass objects if the subclass itself implements a Serializable interface

import java.io.Serializable;

class Subclass extends NonSerializableSuperclass implements Serializable {
	private static final long serialVersionUID = 1L;

	private String serializableField;

	public Subclass(String nonSerializableField, String serializableField) {
		super(nonSerializableField);
		this.serializableField = serializableField;
	}

	public String getSerializableField() {
		return serializableField;
	}

}
