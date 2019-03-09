package de.andrena.schulung.hibernate.uebung5.dao;

import de.andrena.schulung.hibernate.uebung5.domain.Person;

public interface PersonDao {

	void persist(Person person);

	Person findById(long id);

	void flush();
}