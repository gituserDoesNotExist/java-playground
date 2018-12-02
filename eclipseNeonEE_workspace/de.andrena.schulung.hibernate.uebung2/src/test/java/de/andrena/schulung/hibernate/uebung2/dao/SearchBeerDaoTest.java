package de.andrena.schulung.hibernate.uebung2.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.andrena.schulung.hibernate.uebung2.domain.Beer;
import de.andrena.schulung.hibernate.uebung2.domain.BeerBuilder;

public class SearchBeerDaoTest extends AbstractDaoTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUp() {
		super.setUp();
		Beer becksGold = BeerBuilder.createBecksGold();
		beerDao.saveBeer(becksGold);
		flushAndClear();
	}

	// TODO Übung 2 Aufgabe 14: (Unscharfe Suche mit Wildcards)
	// Der Anwender möchte an der Oberfläche nach verschiedenen Brauereien
	// suchen. Um ihm die Suche zu vereinfachen wollen wir ihm Wildcards
	// anbieten. Auch Groß- und Kleinschreibung sind bei der Suche egal.
	// Tip: Schaue dir die CriteriaBuilder-Klasse genauer an.
	@Test
	public void findBeerByBrewery() {
		assertThat(numberOfBeersForBrewery("Rothaus"), is(0));
		assertThat(numberOfBeersForBrewery("Becks"), is(1));
		assertThat(numberOfBeersForBrewery("Be*"), is(1));
		assertThat(numberOfBeersForBrewery("*cks"), is(1));
		assertThat(numberOfBeersForBrewery("*eck*"), is(1));
		assertThat(numberOfBeersForBrewery("*ECK*"), is(1));
		assertThat(numberOfBeersForBrewery("BECKS"), is(1));
	}

	@Test
	public void nullAlsSucheWirdIgnoriert() {
		assertThat(numberOfBeersForBrewery(null), is(1));
	}

	// TODO Übung 2 Aufgabe 15: (Wiederverwendung der Wildcard-Suche)
	// Du hast das Feature mit der Wildcard-Suche deinem Product Owner im Review
	// gezeigt. Dein Product Owner findet das Feature so hilfreich, dass er es
	// jetzt auch bei anderen Suchen verwenden möchte.
	// Erweitere die Suche mit dem FridgeSearchDto. Achte dabei darauf, keinen
	// Code zu duplizieren.
	// Tip: Die Lösung könnte dir auch bei einer anderen Aufgabe helfen, die
	// zyklomatische Komplexität zu reduzieren.
	private int numberOfBeersForBrewery(String brewery) {
		List<Beer> beers = beerDao.findByBrewery(brewery);
		return beers.size();
	}

}
