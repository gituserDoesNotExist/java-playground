package de.andrena.schulung.hibernate.uebung5.dao;

import static de.andrena.schulung.hibernate.uebung5.domain.PersonBuilder.createPerson;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import de.andrena.schulung.hibernate.uebung5.domain.Person;
import de.andrena.schulung.hibernate.uebung5.testsupport.AbstractIntegrationTest;

public class PersonDaoImplTest extends AbstractIntegrationTest {

	private static final String PERSONS_NAME = "TestName";
	private static final String ANOTHER_NAME = "AnotherTestName";

	@Inject
	private PersonDao personDao;

	private Person person;
	private long personsId;

	@Before
	public void setUp() {
		person = createPerson().withName(PERSONS_NAME).create();
		personDao.persist(person);
		personsId = person.getId();
	}

	private void reloadPerson() {
		person = personDao.findById(personsId);
	}

	@Test
	// TODO Übung 5 Aufgabe 1: (Spring und JTA-Annotationen)
	// Bei der Übung 5 geht es um die Integration von Spring, JPA/Hibernate und
	// JTA. In der Spring-Konfigurationsdatei persistence-config.xml sind
	// bereits EntityManager und TransactionManager konfiguriert. Für das
	// Transaction-Management fehlen noch die Transaktionsgrenzen. Setze diese
	// zunächst im DAO mit der @Transactional-Annotation.
	public void aPersonCanBeInitiallySaved() {
		reloadPerson();

		assertThat(person.getName(), is(PERSONS_NAME));
	}

	// TODO Übung 5 Aufgabe 2: (Spring und JTA-Annotationen)
	// Wie wurde die Transaktion in den Übungen bislang ohne Spring Transaction
	// Management gesteuert? Was sind die Vorteile des Annotations-basierten
	// Transaction Managements?

	@Test
	// TODO Übung 5 Aufgabe 3: (Persistierte Entitäten aktualisieren)
	// Die Methode persist aus dem Interface EntityManager persistiert eine
	// Entität initial. Mit welcher Methode lassen sich danach Änderungen mit
	// dem persistierten Stand zusammenführen? Erweitere das PersonDao um eine
	// entsprechende Methode und repariere damit diesen Test. Bitte füge auch
	// einen Aufruf der neuen Methode in updatePerson von PersonServiceImpl ein!
	public void aSavedPersonCanBeModified() throws Exception {
		person.setName(ANOTHER_NAME);

		personDao.persist(person);

		reloadPerson();
		assertThat(person.getName(), is(ANOTHER_NAME));
	}

}
