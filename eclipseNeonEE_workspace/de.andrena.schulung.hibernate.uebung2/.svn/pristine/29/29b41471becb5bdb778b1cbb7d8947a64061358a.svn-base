package de.andrena.schulung.hibernate.uebung2.dao;

import static de.andrena.schulung.hibernate.uebung2.domain.AddressBuilder.createAddress;
import static de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder.createBecksGold;
import static de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder.createHoepfnerHefe;
import static de.andrena.schulung.hibernate.uebung2.domain.BottleBuilder.createBottle;
import static de.andrena.schulung.hibernate.uebung2.domain.FridgeBuilder.createFridge;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.andrena.schulung.hibernate.uebung2.domain.Beer;
import de.andrena.schulung.hibernate.uebung2.domain.Bottle;
import de.andrena.schulung.hibernate.uebung2.domain.BottleSize;
import de.andrena.schulung.hibernate.uebung2.domain.Fridge;

public class FridgeDaoTest extends AbstractDaoTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private Beer hoepfnerHefe = createHoepfnerHefe();
	private Beer becksGold = createBecksGold();

	private Bottle goldBottle1 = createBottle().withBeer(becksGold).withSize(BottleSize.NULL_FUENF).create();
	private Bottle goldBottle2 = createBottle().withBeer(becksGold).withSize(BottleSize.EIN_LITER).create();
	private Bottle hefeBottle1 = createBottle().withBeer(hoepfnerHefe).withSize(BottleSize.NULL_DREI_DREI).create();

	// TODO Übung 2 Aufgabe 05: (Cascading Save)
	// Flaschen sollen automatisch mitgespeichert werden, wenn ein Kühlschrank
	// abgespeichert wird.
	@Test
	public void testCascadingSave() {
		beerDao.saveBeer(becksGold);
		beerDao.saveBeer(hoepfnerHefe);
		Fridge fridge = createFridge().withBottle(goldBottle1).withBottle(goldBottle2).withBottle(hefeBottle1).create();
		fridgeDao.saveFridge(fridge);

		flushAndClear();

		fridge = fridgeDao.findById(fridge.getId());
		assertThat(fridge.getBottles(), is(not(nullValue())));
		assertThat(getBottleIds(fridge.getBottles()), hasItems(getBottleIds(goldBottle1, goldBottle2, hefeBottle1)));
	}

	// TODO Übung 2 Aufgabe 06: (Orphan Removal)
	// Flaschen, die aus dem Kühlschrank entfernt werden, sollen automatisch
	// gelöscht werden.
	// Ergänze die JPA-Annotation aus der vorherigen Aufgabe so, dass eine
	// "Bottle" automatisch aus der Datenbank gelöscht wird, wenn sie aus der
	// Liste "Fridge.bottles" entfernt wird.
	// Tip: Diese Aufgabe soll NICHT über die Annotation CascadeType.REMOVE
	// gelöst werden!
	@Test
	public void testCascadingRemove() {
		beerDao.saveBeer(becksGold);
		Fridge fridge = createFridge().withBottle(goldBottle1).create();
		fridgeDao.saveFridge(fridge);

		flushAndClear();

		fridge = fridgeDao.findById(fridge.getId());
		Bottle aBottle = fridge.getBottles().get(0);
		fridge.getBottles().remove(aBottle);

		flushAndClear();

		fridge = fridgeDao.findById(fridge.getId());
		assertThat(fridge.getBottles().size(), is(0));
		assertThat(bottleDao.findById(aBottle.getId()), is(nullValue()));
	}

	// TODO Übung 2 Aufgabe 07: (Cascading-Operationen)
	// Welche Cascading-Optionen gibt es? Was bedeuten die Cascading-Optionen?
	//
	// 1) ...
	// 2) ...
	// 3) ...
	// 4) ...
	// 5) ...

	// TODO Übung 2 Aufgabe 08: (Embedded-Objekte)
	// Die Adresse des Kühlschrankherstellers soll in der gleichen Tabelle wie
	// der des Kühlschrankes gespeichert werden.
	// Füge die passenden JPA-Annotationen zu den Entitäten "Fridge" und
	// "Adress" hinzu.
	// Tip: Die ID in der Klasse "Address" wird danach nicht mehr benötigt.
	@Test
	public void saveAndFindFridge() throws Exception {
		Fridge fridge = createFridge() //
				.withAddress(createAddress() //
						.withCity("München") //
						.withStreet("Am Platzl") //
						.withNumber("42") //
						.create()) //
				.create();
		fridgeDao.saveFridge(fridge);

		fridge = fridgeDao.findById(fridge.getId());

		assertThat(fridge.getAddress().getCity(), is("München"));

		// Die Adresse soll in der gleichen Tabelle wie der Kühlschrank
		// gespeichert werden. Normalerweise würde man das
		// nicht testen.
		String city = (String) entityManager.createNativeQuery("select city from Fridge").getSingleResult();
		assertThat(city, is("München"));
	}

	// TODO Übung 2 Aufgabe 09: (Wiederverwendung von Embedded-Objekten)
	// Kann ein Embedded Objekt in einer anderen Entity wiederverwendet werden?
	//
	// [ ] Ja
	// [ ] Nein
	//
	// Wieso verwende ich Embedded-Objekte wenn diese am Ende in der gleichen
	// Tabelle gespeichert werden?
	//
	// Weil: ...

	// TODO Übung 2 Aufgabe 10: (Sortierte Liste von abhängigen Objekten)
	// Die Flaschen des Kühlschranks sollen nach der Flaschengröße sortiert
	// zurückgegeben werden.
	@Test
	public void getSortedBottles() throws Exception {
		beerDao.saveBeer(becksGold);
		beerDao.saveBeer(hoepfnerHefe);
		Fridge fridge = createFridge() //
				.withBottle(goldBottle1) //
				.withBottle(goldBottle2) //
				.withBottle(hefeBottle1) //
				.create();
		fridgeDao.saveFridge(fridge);

		flushAndClear();

		fridge = fridgeDao.findById(fridge.getId());

		List<Bottle> bottles = fridge.getBottles();
		assertThat(bottles.get(0).getBottleSize(), is(BottleSize.NULL_DREI_DREI));
		assertThat(bottles.get(1).getBottleSize(), is(BottleSize.NULL_FUENF));
		assertThat(bottles.get(2).getBottleSize(), is(BottleSize.EIN_LITER));
	}

	// Die Biersorte soll nicht kaskadierend gespeichert werden.
	@Test
	public void throwErrorWhenSavingTransientDependencies() {
		Fridge fridge = createFridge().withBottle(goldBottle1).withBottle(goldBottle2).withBottle(hefeBottle1).create();
		expectedException.expect(IllegalStateException.class);
		fridgeDao.saveFridge(fridge);
	}

	private static Long[] getBottleIds(Bottle... bottles) {
		List<Long> bottleIds = getBottleIds(Arrays.asList(bottles));
		return bottleIds.toArray(new Long[bottleIds.size()]);
	}

	private static List<Long> getBottleIds(List<Bottle> bottles) {
		return bottles.stream().map(bottle -> bottle.getId()).collect(Collectors.toList());
	}
}
