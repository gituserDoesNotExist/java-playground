package de.andrena.schulung.hibernate.uebung2.dao;

import static de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder.createBecksGold;
import static de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder.createHoepfnerHefe;
import static de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder.createHoepfnerPilsner;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.persistence.PersistenceException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.andrena.schulung.hibernate.uebung2.domain.Beer;
import de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder;

public class BeerDaoTest extends AbstractDaoTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// TODO Übung 2 Aufgabe 04: (Unique Constraints)
	// Die Kombination aus Brauerei und Name soll bei Entitäten der Klasse
	// "Beer" immer eindeutig sein.
	@Test
	public void beersWithSameBreweryAndSameNameCannotBeSaved() throws Exception {
		beerDao.saveBeer(createBecksGold());
		Beer anotherBecksGold = new BeerBuilder().withBrewery("Becks").withName("Gold").create();

		expectedException.expect(PersistenceException.class);
		beerDao.saveBeer(anotherBecksGold);
		flushAndClear();
	}

	// Dieser Test gehört auch noch zu Übung 2 Aufgabe 04.
	@Test
	public void beersWithSameBreweryButDifferentNamesCanBeSaved() {
		Beer hoepfnerPilsner = createHoepfnerPilsner();
		Beer hoepfnerHefe = createHoepfnerHefe();

		beerDao.saveBeer(hoepfnerPilsner);
		beerDao.saveBeer(hoepfnerHefe);
		flushAndClear();

		assertThat(hoepfnerPilsner.getId(), is(notNullValue()));
		assertThat(hoepfnerHefe.getId(), is(notNullValue()));
	}
}
