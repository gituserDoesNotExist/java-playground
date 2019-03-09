package de.andrena.schulung.hibernate.uebung4.dao;

import javax.persistence.EntityManager;

import de.andrena.schulung.hibernate.uebung4.dao.domain.Person;

public class PersonDao {

	private EntityManager entityManager;

	public Person savePerson(Person person) {
		entityManager.persist(person);
		return person;
	}

	public Person findById(Long id) {
		return entityManager.find(Person.class, id);
	}

	void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
