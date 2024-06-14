/*
DAY : 12
ASSIGNMENT NO :05

Create a java program if superclass is Serializable but you don’t want subclass to
be Serializable

*/
package net.texala.main;  ////subclass is not serializable so its fields are not included in the serialization process so those will be initialized to default value

class Subclass extends Superclass {
	private transient String nonSerializableField;

	public Subclass(String superField, String nonSerializableField) {
		super(superField);
		this.nonSerializableField = nonSerializableField;
	}

	public String getNonSerializableField() {
		return nonSerializableField;
	}

}
