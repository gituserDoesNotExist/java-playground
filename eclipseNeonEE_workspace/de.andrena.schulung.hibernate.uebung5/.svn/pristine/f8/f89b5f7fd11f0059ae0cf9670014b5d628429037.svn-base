package de.andrena.schulung.hibernate.uebung5.service;

import static de.andrena.schulung.hibernate.uebung5.domain.PersonBuilder.createPerson;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import de.andrena.schulung.hibernate.uebung5.domain.Beer;
import de.andrena.schulung.hibernate.uebung5.domain.BeerBuilder;
import de.andrena.schulung.hibernate.uebung5.domain.Person;
import de.andrena.schulung.hibernate.uebung5.domain.PersonNotOfAgeException;
import de.andrena.schulung.hibernate.uebung5.testsupport.AbstractIntegrationTest;

public class PersonServiceIntegrationTest extends AbstractIntegrationTest {

	private static final int AGE_BELOW_LEGAL_AGE = 14;

	@Inject
	private PersonService personService;

	private Person person;
	private long personsId;

	private Beer aBeer;

	@Before
	public void setUp() {
		person = createPerson().create();
		personService.savePerson(person);
		personsId = person.getId();

		aBeer = BeerBuilder.createBeer().create();
	}

	private void reloadPerson() {
		person = personService.loadPerson(personsId);
	}

	@Test
	// TODO Übung 5 Aufgabe 4: (Scope einer Transaktion)
	// Beim Hinzufügen des Biers in diesem Test sind mehrere DAOs an einer
	// Service-Methode beteiligt. Wie kann der gesamte Vorgang innerhalb einer
	// Transaktion erfolgen?
	public void aPersonOfAgeCanHaveABeer() throws Exception {
		personService.addBeer(person, aBeer);

		reloadPerson();
		assertThat(person.getBeers(), contains(aBeer));
	}

	// TODO Übung 5 Aufgabe 5: (Sinnvolle Ebene für Transaktionen)
	// Eine @Transactional-Annotation kann auf DAOs und auf Services, auf
	// Methoden- und auf Klassenebene gesetzt werden.
	// Was ist in der Regel die am besten geeignete Ebene? Warum?

	@Test
	// TODO Übung 5 Aufgabe 6: (Rollback von Transaktionen bei Exceptions)
	// Wenn während einer Transaktion im Service eine Exception auftritt, soll
	// die Transaktion zurückgerollt werden.
	// Erweitere die @Transactional-Annotation entsprechend.
	public void anUnderagePersonCannotHaveABeer() throws Exception {
		person.setAge(AGE_BELOW_LEGAL_AGE);
		personService.updatePerson(person);

		try {
			personService.addBeer(person, aBeer);
		} catch (PersonNotOfAgeException e) {
			// ok, should have caused the transaction to rollback...
		}

		reloadPerson();
		assertThat(person.getBeers(), is(empty()));
	}

	// TODO Übung 5 Aufgabe 7: (Rollback von Transaktionen bei Exceptions)
	// Manche Arten von Exceptions führen nach der JTA-Spezifikation automatisch
	// zu einem Rollback. Wie hätte man den Test somit noch grün bekommen
	// können?

}
