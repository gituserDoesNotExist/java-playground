package de.andrena.schulung.hibernate.uebung3.service;

import javax.persistence.EntityManager;

import de.andrena.schulung.hibernate.uebung3.dao.PersonDao;
import de.andrena.schulung.hibernate.uebung3.domain.Person;

public class PersonService {

	private PersonDao personDao;

	private EntityManager entityManager;

	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}

	public Person savePerson(Person person) {
		entityManager.getTransaction().begin();
		Person savedPerson = personDao.savePerson(person);
		entityManager.getTransaction().commit();
		return savedPerson;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
