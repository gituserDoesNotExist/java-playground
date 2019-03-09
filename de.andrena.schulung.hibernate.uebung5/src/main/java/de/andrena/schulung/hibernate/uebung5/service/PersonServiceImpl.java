package de.andrena.schulung.hibernate.uebung5.service;

import javax.inject.Inject;
import javax.inject.Named;

import de.andrena.schulung.hibernate.uebung5.dao.BeerDao;
import de.andrena.schulung.hibernate.uebung5.dao.PersonDao;
import de.andrena.schulung.hibernate.uebung5.domain.Beer;
import de.andrena.schulung.hibernate.uebung5.domain.Person;
import de.andrena.schulung.hibernate.uebung5.domain.PersonNotOfAgeException;

@Named
public class PersonServiceImpl implements PersonService {

	private static final int LEGAL_AGE = 18;

	@Inject
	private PersonDao personDao;

	@Inject
	private BeerDao beerDao;

	@Override
	public void savePerson(Person person) {
		personDao.persist(person);
		personDao.flush();
	}

	@Override
	public Person loadPerson(long id) {
		return personDao.findById(id);
	}

	@Override
	public void updatePerson(Person person) throws PersonNotOfAgeException {
		checkLegalAge(person);

		// hier muss die neue Methode aus Übung 5 Aufgabe 3 aufgerufen werden

		personDao.flush();
	}

	@Override
	public void addBeer(Person person, Beer beer) throws PersonNotOfAgeException {
		beerDao.persist(beer);
		person.addBeer(beer);
		updatePerson(person);
	}

	private void checkLegalAge(Person person) throws PersonNotOfAgeException {
		if (!person.getBeers().isEmpty() && person.getAge() < LEGAL_AGE) {
			throw new PersonNotOfAgeException();
		}
	}

}
