package de.andrena.schulung.hibernate.uebung2.domain;

import de.andrena.schulung.hibernate.uebung2.domain.Beer;
import de.andrena.schulung.hibernate.uebung2.domain.Bottle;
import de.andrena.schulung.hibernate.uebung2.domain.BottleSize;

public class BottleBuilder {
	private Bottle bottle = new Bottle();

	public BottleBuilder() {
		bottle.setBottleSize(BottleSize.NULL_DREI_DREI);
	}

	public static BottleBuilder createBottle() {
		return new BottleBuilder();
	}

	public BottleBuilder withBeer(Beer beer) {
		bottle.setBeer(beer);
		return this;
	}

	public BottleBuilder withSize(BottleSize size) {
		bottle.setBottleSize(size);
		return this;
	}

	public Bottle create() {
		return bottle;
	}
}
