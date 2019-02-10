package de.andrena.schulung.hibernate.uebung5.dao;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import de.andrena.schulung.hibernate.uebung5.domain.Person;

@Named
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void persist(Person person) {
	entityManager.persist(person);
    }

    @Override
    public Person findById(long id) {
	return entityManager.find(Person.class, id);
    }

    @Override
    public void flush() {
	entityManager.flush();
    }
}
