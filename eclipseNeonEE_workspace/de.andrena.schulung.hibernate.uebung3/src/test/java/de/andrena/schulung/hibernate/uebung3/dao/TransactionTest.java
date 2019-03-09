package de.andrena.schulung.hibernate.uebung3.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import de.andrena.schulung.hibernate.uebung3.domain.Person;
import de.andrena.schulung.hibernate.uebung3.service.PersonService;

public class TransactionTest {

	private EntityManagerFactory factory;

	protected PersonDao personDao = new PersonDao();

	@Before
	public void setUp() {
		factory = Persistence.createEntityManagerFactory("DefaultPersistenceUnit");
	}

	// TODO Übung 3 Aufgabe 1: (Transaktionen über den EntityManager - Teil 1)
	// Der Test soll explizit zeigen, wie über den EntityManager die Transaktion
	// gestartet wird und am Ende ein Commit erfolgt. Dies würde in einer
	// Anwendung so nicht programmiert werden.
	@Test
	public void testSavePersonDao() throws Exception {
		EntityManager entityManager = factory.createEntityManager();
		personDao.setEntityManager(entityManager);
		entityManager.getTransaction().begin();

		Person person = new Person("Peter");
		person = personDao.savePerson(person);

		assertThat(person.getId(), is(not(nullValue())));
		assertThat(findPerson(entityManager).getName(), is("Peter"));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	// TODO Übung 3 Aufgabe 2: (Transaktionen über den EntityManager - Teil 2)
	// Hier soll ein Service implementiert werden, der sich um die Transaktion
	// kümmert. Durch das Öffnen einer weiteren Transaktion wird die Person aus
	// der Datenbank gelesen. Auch hier geht es darum, das Verhalten einer
	// Transaktion zu zeigen. Dies würde in einer Anwendung so nicht
	// programmiert werden.
	@Test
	public void testSavePersonService() throws Exception {
		EntityManager entityManager = factory.createEntityManager();
		personDao.setEntityManager(entityManager);
		PersonService service = new PersonService(personDao);
		service.setEntityManager(entityManager);

		Person person = new Person("Peter");
		person = service.savePerson(person);

		entityManager.close();

		entityManager = factory.createEntityManager();
		personDao.setEntityManager(entityManager);
		entityManager.getTransaction().begin();

		assertThat(person.getId(), is(not(nullValue())));
		assertThat(findPerson(entityManager).getName(), is("Peter"));

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	// TODO Übung 3 Aufgabe 3: (Einführung von JTA)
	// Für Transaktionen gibt es den Java Transaction API-Standard (JTA).
	// Welche Vorteile hat JTA? Was für Problemstellungen können damit gelöst
	// werden? Stelle dir folgende Situation vor: Ein System in einer Bank
	// schreibt eine Buchung für ein Konto in die Datenbank und führt commit
	// aus. Danach soll eine anderes System über eine JMS-Nachricht informiert
	// werden. Allerdings führt ein Fehler dazu, dass die JMS-Nachricht nicht
	// abgesendet werden kann. Wie kann JTA hier helfen?
	private Person findPerson(EntityManager entityManager) {
		return (Person) entityManager.createQuery("SELECT p FROM Person p").getSingleResult();
	}

}
