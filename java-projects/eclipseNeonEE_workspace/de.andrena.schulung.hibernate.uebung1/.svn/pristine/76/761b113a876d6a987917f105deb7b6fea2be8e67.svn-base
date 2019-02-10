package de.andrena.schulung.hibernate.uebung1.dao;

import static de.andrena.schulung.hibernate.uebung1.domain.PersonBuilder.createPerson;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.andrena.schulung.hibernate.uebung1.domain.Person;

public class PersonDaoTest extends AbstractDaoTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// Anmerkung zum Einstieg in die Übungen:
	// Solltest du noch keinerlei Erfahrungen mit JPA/Hibernate/Annotations
	// haben, ist es sicherlich sinnvoll sich zunächst ein Tutorial von
	// JPA/Hibernate anzuschauen, um die grundsätzlichen Mechanismen zu
	// verstehen. Es gibt beispielsweise Tutorials unter
	// http://hibernate.org/orm/documentation oder auf anderen Seiten (Google!).

	// TODO Übung 1 Aufgabe 1: (Objekt speichern und aktualisieren)
	// Speichere eine Person. Füge dazu die richtigen JPA-Annotationen
	// (javax.persistence.*) zur Klasse "Person" hinzu und ergänze die fehlende
	// Implementierung in der Klasse "PersonDao".
	@Test
	public void savePerson() {
		Person person = personDao.savePerson(new Person("Peter"));

		flushAndClear();

		assertThat(person.getId(), is(not(nullValue())));
		assertThat(findPerson().getName(), is("Peter"));
	}

	// Dieser Test gehört auch noch zu Übung 1 Aufgabe 1.
	@Test
	public void updatePerson() {
		Person person = new Person("Peter");
		personDao.savePerson(person);

		person.setName("Hans");
		personDao.savePerson(person);

		flushAndClear();

		assertThat(findPerson().getName(), is("Hans"));
	}

	// TODO Übung 1 Aufgabe 2: (Not Null-Constraints für Felder)
	// Der Name der Person darf nicht null sein.
	// Diese Aufgabe soll durch eine JPA-Annotation gelöst werden.
	@Test
	public void nameMustNotBeNull() {
		Person person = new Person(null);

		expectedException.expect(PersistenceException.class);
		expectedException.expectMessage(containsString("not-null property references a null or transient value"));
		personDao.savePerson(person);
	}

	// TODO Übung 1 Aufgabe 3: (Alternative Namen für Tabellen und Spalten)
	// Stelle dir folgende Situation vor: Die Personen werden von einer
	// SAP-Datenbank importiert. Die Tabellen- und Spaltennamen stehen schon
	// fest und wir können diese nicht ändern. Wir wollen aber die Namen der
	// Attribute und die Klassennamen in unseren Java-Klassen nicht anpassen, da
	// wir die Namen der Spalten und Tabellen in der Datenbank nicht sinnvoll
	// finden.
	// Passe das Mapping der Attribute auf die Spaltennamen und die
	// Tabellennamen an.
	// Diese Aufgabe soll durch JPA-Annotationen gelöst werden.
	@Test
	public void askChangeColumnName() {
		Person person = createPerson().withName("Paul").withAge(23).create();
		personDao.savePerson(person);

		flushAndClear();

		Integer alter = (Integer) entityManager.createNativeQuery("select SAP_AGE from SAP_PERSON").getSingleResult();
		assertThat(alter, is(23));
	}

	private Person findPerson() {
		return (Person) entityManager.createQuery("SELECT p FROM Person p").getSingleResult();
	}

	// TODO Übung 1 Aufgabe 4: (Änderung von Spaltenname bei Tabelle)
	// Stelle dir folgende Situation vor: Deine Anwendung läuft produktiv. Du
	// möchtest den Namen eines Attributs einer Entity verändern. Worauf musst
	// du achten?

	// TODO Übung 1 Aufgabe 5: (Annotations als Mappingdefinition)
	// Was sind die Vor- und Nachteile davon, das Datenbank-Mapping in den
	// Annotationen immer mit anzugeben?

	// TODO Übung 1 Aufgabe 6: (Automatische IDs von Hibernate)
	// Wie funktioniert die automatische Vergabe von IDs mit Hibernate? Wenn du
	// verschiedene Entities anlegst (z.B. Person und Firma), verwenden diese
	// Entities dann unterschiedliche Sequenznummern?

	// TODO Übung 1 Aufgabe 7: (Objekte anhand der ID laden)
	// Versuche die Person anhand der ID über den EntityManager zu finden.
	@Test
	public void findPersonById() {
		personDao.savePerson(new Person("Hans"));
		Person person = new Person("Peter");
		personDao.savePerson(person);
		Long id = person.getId();
		flushAndClear();

		person = personDao.findById(id);
		assertThat(person.getName(), is("Peter"));
	}

	// TODO Übung 1 Aufgabe 8: (JPA Criteria API - Normale Suche)
	// Diese Aufgabe zielt darauf ab, JPA-Criterias zu verwenden, um den
	// Datenbestand zu durchsuchen und die Ergebnisse zu filtern.
	// Versuche alle Personen mit dem gleichen Alter zu finden.
	// Diese Aufgabe soll durch JPA-Criterias gelöst werden.
	@Test
	public void createPersonAgeCriteria() {
		Person paul = createPerson().withName("Paul").withAge(12).create();
		personDao.savePerson(paul);

		Person fred = createPerson().withName("Fred").withAge(42).create();
		personDao.savePerson(fred);

		Person youngFred = createPerson().withName("Fred").withAge(35).create();
		personDao.savePerson(youngFred);

		flushAndClear();

		List<Person> personen = personDao.findPersonsWithAge(35);
		assertThat(personen.size(), is(1));
		Person person = personen.get(0);
		assertThat(person.getId(), is(youngFred.getId()));
	}

	// TODO Übung 1 Aufgabe 9: (JPA Criteria API - Maximum-Suche)
	// Suche das maximale Alter der Personen.
	// Diese Aufgabe soll durch JPA-Criterias gelöst werden.
	@Test
	public void findMaxAge() {
		Person paul = createPerson().withName("Paul").withAge(12).create();
		personDao.savePerson(paul);

		Person fred = createPerson().withName("Fred").withAge(42).create();
		personDao.savePerson(fred);

		Person youngFred = createPerson().withName("Fred").withAge(35).create();
		personDao.savePerson(youngFred);

		flushAndClear();

		int maxAge = personDao.findMaxAge();
		assertThat(maxAge, is(42));
	}

}
