package de.andrena.schulung.hibernate.uebung3.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.andrena.schulung.hibernate.uebung3.domain.Person;
import de.andrena.schulung.hibernate.uebung3.domain.PersonBuilder;

public class SessionTest extends AbstractDaoTest {

	// TODO Übung 3 Aufgabe 4: (Verhalten der Session - Teil 1)
	// In diesem Test geht es um die Session und deren Lebenszyklus. Persistente
	// Objekte werden in der Session verwaltet. Gibt es Änderungen an diesen
	// Objekten, werden diese automatisch in die Datenbank gespeichert, ohne
	// dass der Aufruf eines expliziten persist am EntityManager notwändig wäre.
	@Test
	public void testSessionWithoutClear() throws Exception {

		Person person = new PersonBuilder().withName("Hans").create();
		person = personDao.savePerson(person);
		Long id = person.getId();
		person.setName("Peter");

		flushAndClear();

		Person result = personDao.findById(id);
		assertThat(result.getName(), is("Peter"));
	}

	// TODO Übung 3 Aufgabe 5: (Verhalten der Session - Teil 2)
	// Bei diesem Test wird erwartet, dass nach dem Speichern die Session
	// geleert wird. Danach gibt es keine Objekte mehr in der Session. Die nach
	// dem Leeren der Session vorgenommenen Änderungen werden nicht mehr
	// persistiert.
	@Test
	public void testSessionWithFlushAndClear() throws Exception {

		Person person = new PersonBuilder().withName("Hans").create();
		person = personDao.savePersonWithFlushAndClear(person);
		Long id = person.getId();
		person.setName("Peter");

		flushAndClear();

		Person result = personDao.findById(id);
		assertThat(result.getName(), is("Hans"));
	}
}
