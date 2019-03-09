package de.andrena.schulung.spring.haendler.hehler;

import java.util.Set;

import de.andrena.schulung.spring.haendler.Haendler;
import de.andrena.schulung.spring.haendler.Taler;
import de.andrena.schulung.spring.haendler.Ware;

public class Hehler implements Haendler {

	private Haendler haendler;
	private Spelunke spelunke;

	public Hehler(Haendler haendler) {
		this.haendler = haendler;
	}

	public void kaufe(Ware ware) {
		haendler.kaufe(ware);
	}

	public void verkaufe(Ware ware) {
		haendler.verkaufe(ware);
	}

	public Set<Ware> angebot() {
		return haendler.angebot();
	}

	public Taler vermoegen() {
		return haendler.vermoegen();
	}

	public boolean kannBeschaffen(Ware ware) {
		if (spelunke == null)
			return false;
		for (Dieb dieb : spelunke.nenneDiebe()) {
			if (dieb.kannBesorgen(ware))
				return true;
		}
		return false;
	}

}
