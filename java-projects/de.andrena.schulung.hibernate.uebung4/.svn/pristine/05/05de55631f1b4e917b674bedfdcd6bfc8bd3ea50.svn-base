package de.andrena.schulung.hibernate.uebung4.domain;

import de.andrena.schulung.hibernate.uebung4.dao.domain.Activity;
import de.andrena.schulung.hibernate.uebung4.dao.domain.Person;

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
	
	public PersonBuilder withTaetigkeit(Activity taetigkeit) {
		person.setActivity(taetigkeit);
		return this;
	}
	
	public PersonBuilder withPassportNumber(String passportNumber) {
		person.setPassportNumber(passportNumber);
		return this;
	}
	
	public PersonBuilder withEmail(String email) {
		person.setEmailadresse(email);
		return this;
	}

	public Person create() {
		return person;
	}

}
