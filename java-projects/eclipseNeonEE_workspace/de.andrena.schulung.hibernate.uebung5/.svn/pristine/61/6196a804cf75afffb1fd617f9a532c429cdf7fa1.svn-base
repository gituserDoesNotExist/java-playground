package de.andrena.schulung.hibernate.uebung5.domain;

public class BeerBuilder {

	private Beer beer;

	public BeerBuilder() {
		beer = new Beer();
		beer.setName("Schlappeseppel");
	}

	public static BeerBuilder createBeer() {
		return new BeerBuilder();
	}

	public BeerBuilder withName(String name) {
		beer.setName(name);
		return this;
	}

	public Beer create() {
		return beer;
	}

}
