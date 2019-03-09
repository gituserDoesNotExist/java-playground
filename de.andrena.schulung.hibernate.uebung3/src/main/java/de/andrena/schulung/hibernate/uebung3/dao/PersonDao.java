package de.andrena.schulung.hibernate.uebung3.dao;

import javax.persistence.EntityManager;

import de.andrena.schulung.hibernate.uebung3.domain.Person;

public class PersonDao {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Person savePerson(Person person) {
		return null;
	}

	public Person findById(Long id) {
		return entityManager.find(Person.class, id);
	}

	// Diese Methode ist nur für Demonstrationszwecke. In einer Anwendung gibt
	// es zunächst keinen Grund für eine derartige Methode.
	public Person savePersonWithFlushAndClear(Person person) {
		return null;
	}
}
