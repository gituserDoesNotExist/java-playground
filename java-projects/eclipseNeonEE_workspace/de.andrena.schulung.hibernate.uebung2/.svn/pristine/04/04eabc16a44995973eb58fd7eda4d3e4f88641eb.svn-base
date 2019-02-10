package de.andrena.schulung.hibernate.uebung2.dao;

import static de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder.createBecksGold;
import static de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder.createHoepfnerHefe;
import static de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder.createHoepfnerPilsner;
import static de.andrena.schulung.hibernate.uebung2.domain.BottleBuilder.createBottle;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.andrena.schulung.hibernate.uebung2.domain.Beer;
import de.andrena.schulung.hibernate.uebung2.domain.Bottle;
import de.andrena.schulung.hibernate.uebung2.domain.BottleBuilder;
import de.andrena.schulung.hibernate.uebung2.domain.BottleSize;

public class BottleDaoTest extends AbstractDaoTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// TODO Übung 2 Aufgabe 01: (Assoziationen)
	// Speichere Biere und Bierflaschen. Füge dazu die JPA-Annotationen zu den
	// Entitäten "Beer" und "Bottle" hinzu und ergänze die fehlenden
	// Implementierungen in den Klassen "BeerDao" und "BottleDao".
	@Test
	public void testSaveBottles() throws Exception {
		Beer becksGold = createBecksGold();
		beerDao.saveBeer(becksGold);

		Bottle bottleOne = createBottle().withBeer(becksGold).create();
		bottleDao.saveBottle(bottleOne);
		Bottle bottleTwo = createBottle().withBeer(becksGold).withSize(BottleSize.NULL_FUENF).create();
		bottleDao.saveBottle(bottleTwo);

		flushAndClear();

		Bottle bottle = bottleDao.findById(bottleOne.getId());
		assertThat(bottle.getBottleSize(), is(BottleSize.NULL_DREI_DREI));
		assertThat(bottle.getBeer(), is(notNullValue()));
		assertThat(bottle.getBeer().getId(), is(becksGold.getId()));
		bottle = bottleDao.findById(bottleTwo.getId());
		assertThat(bottle.getBottleSize(), is(BottleSize.NULL_FUENF));
		assertThat(bottle.getBeer(), is(notNullValue()));
		assertThat(bottle.getBeer().getId(), is(becksGold.getId()));
	}

	// TODO Übung 2 Aufgabe 02: (Suche über abhängige Objekte)
	// Suche alle Flaschen von einer bestimmten Biersorte.
	@Test
	public void testFindByBeer() throws Exception {
		Beer pils = createHoepfnerPilsner();
		beerDao.saveBeer(pils);
		Beer hefe = createHoepfnerHefe();
		beerDao.saveBeer(hefe);

		Bottle bottlePils = createBottle().withBeer(pils).create();
		bottleDao.saveBottle(bottlePils);
		bottleDao.saveBottle(createBottle().withBeer(hefe).create());

		flushAndClear();
		List<Bottle> bottles = bottleDao.findByBeer(pils);
		assertThat(bottles.size(), is(1));
		assertThat(bottles.get(0).getId(), is(bottlePils.getId()));
	}

	// TODO Übung 2 Aufgabe 03: (Not Null-Constraints für abhängige Objekte)
	// Jede Flasche ist von einer Biersorte, d.h. die Biersorte darf nicht null
	// sein.
	// Diese Aufgabe soll durch JPA-Annotationen gelöst werden.
	@Test
	public void testBeerNotNull() throws Exception {
		Bottle bottle = new BottleBuilder().withBeer(null).create();

		expectedException.expect(PersistenceException.class);
		bottleDao.saveBottle(bottle);
	}

}
