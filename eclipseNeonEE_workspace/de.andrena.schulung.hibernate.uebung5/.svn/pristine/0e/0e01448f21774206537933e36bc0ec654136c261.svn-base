package de.andrena.schulung.hibernate.uebung5.domain;

public class PersonBuilder {

	private Person person;

	public PersonBuilder() {
		person = new Person("Test");
		person.setAge(34);
	}

	public static PersonBuilder createPerson() {
		return new PersonBuilder();
	}

	public PersonBuilder withName(String name) {
		person.setName(name);
		return this;
	}

	public PersonBuilder withAge(int age) {
		person.setAge(age);
		return this;
	}

	public Person create() {
		return person;
	}

}
