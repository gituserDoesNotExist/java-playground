package de.andrena.schulung.hibernate.uebung2.dao;

import static de.andrena.schulung.hibernate.uebung2.domain.BottleBuilder.createBottle;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.andrena.schulung.hibernate.uebung2.domain.Address;
import de.andrena.schulung.hibernate.uebung2.domain.Beer;
import de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder;
import de.andrena.schulung.hibernate.uebung2.domain.Bottle;
import de.andrena.schulung.hibernate.uebung2.domain.BottleSize;
import de.andrena.schulung.hibernate.uebung2.domain.Fridge;

public class SearchFridgeDaoTest extends AbstractDaoTest {

	private FridgeSearchDto searchDto = new FridgeSearchDto();

	@Before
	public void setUp() {
		super.setUp();
		Fridge fridge = new Fridge();
		Address address = new Address();
		address.setCity("München");
		fridge.setAddress(address);
		fridge.setManufacturer("Bosch");

		Beer becksGold = BeerBuilder.createBecksGold();
		beerDao.saveBeer(becksGold);
		Bottle bottleBecks = createBottle().withBeer(becksGold).withSize(BottleSize.EIN_LITER).create();
		bottleDao.saveBottle(bottleBecks);

		Beer hoepfnerHefe = BeerBuilder.createHoepfnerHefe();
		beerDao.saveBeer(hoepfnerHefe);
		Bottle bottleHoepfner = createBottle().withBeer(hoepfnerHefe).withSize(BottleSize.NULL_DREI_DREI).create();
		bottleDao.saveBottle(bottleHoepfner);

		fridge.setBottles(Arrays.asList(bottleBecks));

		fridgeDao.saveFridge(fridge);
		flushAndClear();
	}

	// TODO Übung 2 Aufgabe 11: (Komplexe Suchen - Sub-Criterias)
	// Dein Product Owner möchte nach Kühlschränken suchen können. Das Problem
	// für dich dabei ist: Die Attribute, nach denen gesucht werden muss, sind
	// in unterschiedlichen Entities. Wenn der Benutzer nichts eingibt, soll
	// auch nicht gefiltert werden. Dadurch wird die Suche etwas komplizierter.
	// Dieser Fall tritt aber häufig in realen Anwendungen auf.
	// Tip: Verwende createCriteria(), um Sub-Criterias zu erzeugen.
	@Test
	public void testEmptySearchDoesNotFilter() {
		assertThat(countFridges(searchDto), is(1));
	}

	@Test
	public void testFindByManufacturer() {
		searchDto.setManufacturer("Bosch");
		assertThat(countFridges(searchDto), is(1));

		searchDto.setManufacturer("BMW");
		assertThat(countFridges(searchDto), is(0));
	}

	@Test
	public void testFindByBrewery() {
		searchDto.setBrewery("Becks");
		assertThat(countFridges(searchDto), is(1));

		searchDto.setBrewery("Audi");
		assertThat(countFridges(searchDto), is(0));

		searchDto.setBrewery("Privatbrauerei Hoepfner GmbH");
		assertThat(countFridges(searchDto), is(0));
	}

	@Test
	public void testFindByBottleSize() {
		searchDto.setBottleSize(BottleSize.EIN_LITER);
		assertThat(countFridges(searchDto), is(1));

		searchDto.setBottleSize(BottleSize.NULL_DREI_DREI);
		assertThat(countFridges(searchDto), is(0));
	}

	@Test
	public void testFindByCity() {
		searchDto.setCity("München");
		assertThat(countFridges(searchDto), is(1));

		searchDto.setCity("Paris");
		assertThat(countFridges(searchDto), is(0));
	}

	// TODO Übung 2 Aufgabe 12: (Komplexe Suchen - Verwendung von Sub-Criteria)
	// Wann verwende ich Sub-Criteria?
	//
	// [ ] OneToOne-Beziehungen
	// [ ] OneToMany-Beziehungen
	// [ ] Embedded-Objekte

	// TODO Übung 2 Aufgabe 13: (Komplexe Suchen - Zyklomatische Komplexität)
	// Welche zyklomatische Komplexität hat deine Lösung für die Suche?
	//
	// Zyklomatische Komplexität: _____
	private int countFridges(FridgeSearchDto searchDto) {
		List<Fridge> fridge = fridgeDao.findBy(searchDto);
		return fridge.size();
	}

}
