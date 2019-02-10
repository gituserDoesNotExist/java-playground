package de.andrena.schulung.hibernate.uebung2.domain;

import java.util.ArrayList;

import de.andrena.schulung.hibernate.uebung2.domain.Address;
import de.andrena.schulung.hibernate.uebung2.domain.Bottle;
import de.andrena.schulung.hibernate.uebung2.domain.Fridge;

public class FridgeBuilder {
	private Fridge fridge = new Fridge();

	public static FridgeBuilder createFridge() {
		return new FridgeBuilder();
	}

	public FridgeBuilder() {
		fridge.setBottles(new ArrayList<Bottle>());
	}

	public FridgeBuilder withAddress(Address address) {
		fridge.setAddress(address);
		return this;
	}

	public FridgeBuilder withBottle(Bottle bottle) {
		fridge.getBottles().add(bottle);
		return this;
	}

	public FridgeBuilder withManufacturer(String manufacturer) {
		fridge.setManufacturer(manufacturer);
		return this;
	}

	public FridgeBuilder withVolume(int volume) {
		fridge.setVolume(volume);
		return this;
	}

	public Fridge create() {
		return fridge;
	}
}
