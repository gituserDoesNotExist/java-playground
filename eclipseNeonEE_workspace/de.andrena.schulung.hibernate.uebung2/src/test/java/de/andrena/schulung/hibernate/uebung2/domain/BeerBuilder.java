package de.andrena.schulung.hibernate.uebung2.domain;

import de.andrena.schulung.hibernate.uebung2.domain.Beer;

public class BeerBuilder {

	private Beer beer = new Beer();

	public static BeerBuilder createBeer() {
		return new BeerBuilder();
	}

	public BeerBuilder withName(String name) {
		beer.setName(name);
		return this;
	}

	public BeerBuilder withBrewery(String brewery) {
		beer.setBrewery(brewery);
		return this;
	}

	public Beer create() {
		return beer;
	}

	public static Beer createHoepfnerHefe() {
		return createBeer().withBrewery("Privatbrauerei Hoepfner GmbH").withName("Hoepfner Hefe-Weizen").create();
	}

	public static Beer createHoepfnerPilsner() {
		return createBeer().withBrewery("Privatbrauerei Hoepfner GmbH").withName("Hoepfner Pilsner").create();
	}

	public static Beer createBecksGold() {
		return createBeer().withBrewery("Becks").withName("Gold").create();
	}
}
