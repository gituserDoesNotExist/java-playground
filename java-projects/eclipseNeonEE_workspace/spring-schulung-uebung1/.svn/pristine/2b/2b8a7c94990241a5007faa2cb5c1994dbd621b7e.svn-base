package de.andrena.schulung.spring.haendler;

import static de.andrena.schulung.spring.haendler.Taler.taler;

public class WareBuilder {

	private String name = "unbekanntes Objekt";
	private Taler preis = taler(0);

	public static WareBuilder ware(String name) {
		WareBuilder wareBuilder = new WareBuilder();
		wareBuilder.setName(name);
		return wareBuilder;
	}

	private void setName(String name) {
		this.name = name;
	}

	public WareBuilder withPreis(Taler taler) {
		preis = taler;
		return this;
	}

	public static Ware create(WareBuilder builder) {
		return builder.create();
	}

	public Ware create() {
		Ware ware = new Ware(name);
		ware.setPreis(preis);
		return ware;

	}

}
