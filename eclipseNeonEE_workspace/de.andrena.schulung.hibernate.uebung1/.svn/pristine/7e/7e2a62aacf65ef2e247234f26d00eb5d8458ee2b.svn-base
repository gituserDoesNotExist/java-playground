package de.andrena.schulung.hibernate.uebung1.domain;

import de.andrena.schulung.hibernate.uebung1.domain.Person;

public class PersonBuilder {

	private Person person = new Person("Test");

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
