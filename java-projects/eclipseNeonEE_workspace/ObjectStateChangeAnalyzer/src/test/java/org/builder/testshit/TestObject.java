package org.builder.testshit;

public class TestObject {
	private long id;
	private String name;
	private String website;

	public String getWebsite() {
		return website;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public TestObject(long id, String name, String website) {
		this.id = id;
		this.name = name;
		this.website = website;
	}
}
