package de.andrena.schulung.hibernate.uebung5.service;

import de.andrena.schulung.hibernate.uebung5.domain.Beer;
import de.andrena.schulung.hibernate.uebung5.domain.Person;
import de.andrena.schulung.hibernate.uebung5.domain.PersonNotOfAgeException;

public interface PersonService {

	void savePerson(Person person);

	void updatePerson(Person person) throws PersonNotOfAgeException;

	Person loadPerson(long id);

	void addBeer(Person person, Beer beer) throws PersonNotOfAgeException;

}
