package de.andrena.schulung.spring.haendler;

import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Taler {

	private int anzahl;

	public static Taler taler(int anzahl) {
		return new Taler(anzahl);
	}

	private Taler(int anzahl) {
		this.anzahl = anzahl;
	}

	public Taler minus(Taler taler) {
		return new Taler(anzahl - taler.anzahl);
	}

	public Taler plus(Taler taler) {
		return new Taler(anzahl + taler.anzahl);
	}

	public Taler mal(BigDecimal factor) {
		return new Taler(factor.multiply(valueOf(anzahl))
				.setScale(0, RoundingMode.HALF_UP).intValue());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anzahl;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taler other = (Taler) obj;
		if (anzahl != other.anzahl)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return anzahl + " Taler";
	}

	public boolean lessThan(Taler other) {
		return this.anzahl < other.anzahl;
	}

	public boolean moreThan(Taler other) {
		return this.anzahl > other.anzahl;
	}

}
