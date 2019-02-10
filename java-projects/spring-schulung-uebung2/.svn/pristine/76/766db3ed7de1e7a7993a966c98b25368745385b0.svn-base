package de.andrena.schulung.spring.haendler.simple.listeners;

import de.andrena.schulung.spring.haendler.Haendler;
import de.andrena.schulung.spring.haendler.Ware;
import de.andrena.schulung.spring.haendler.simple.HaendlerListener;

public class FraudDetectingHaendlerListener implements HaendlerListener {

	public void beforeKauf(Haendler haendler, Ware ware) {
		if (haendler.vermoegen().lessThan(ware.preis())) {
			throw new IllegalArgumentException(ware + " is too expensive.");
		}
	}

	public void afterKauf(Haendler haendler, Ware ware) {

	}

	public void beforeVerkauf(Haendler haendler, Ware ware) {
		if (!haendler.angebot().contains(ware)) {
			throw new IllegalArgumentException("you don't own " + ware);
		}
	}

	public void afterVerkauf(Haendler haendler, Ware ware) {

	}

}
