package org.builder;

public class DifferenceContainer {

	private String attribute;
	private String oldValue;
	private String newValue;

	public DifferenceContainer(String attribute, String oldValue, String newValue) {
		this.attribute = attribute;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public String getAttribute() {
		return attribute;
	}

	public String getOldValue() {
		return oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public static DifferenceContainer empty() {
		return new DifferenceContainer("empty", "-", "-");
	}

	@Override
	public String toString() {
		return String.format("Attribute: %s, oldValue: %s, newValue: %s", attribute, oldValue, newValue);

	}

}
