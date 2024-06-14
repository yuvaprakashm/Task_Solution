/*
DAY : 12
ASSIGNMENT NO :05

Create a java program if superclass is Serializable but you don’t want subclass to
be Serializable

*/
package net.texala.main;

import java.io.Serializable;

class Superclass implements Serializable {
	private static final long serialVersionUID = 1L;

	private String superField;

	public Superclass(String superField) {
		this.superField = superField;
	}

	public String getSuperField() {
		return superField;
	}

}