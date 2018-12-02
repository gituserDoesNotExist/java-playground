package de.andrena.schulung.spring.haendler;

public class Ware {

	private final String bezeichnung;
	private Taler preis;

	public Ware(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Taler preis() {
		return preis;
	}

	@Override
	public String toString() {
		return bezeichnung;
	}

	public void setPreis(Taler taler) {
		preis = taler;
	}
}
