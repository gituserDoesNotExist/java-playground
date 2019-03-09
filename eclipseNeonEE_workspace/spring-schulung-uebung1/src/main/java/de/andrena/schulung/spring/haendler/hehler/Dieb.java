package de.andrena.schulung.spring.haendler.hehler;

import java.util.HashSet;
import java.util.Set;

import de.andrena.schulung.spring.haendler.Haendler;
import de.andrena.schulung.spring.haendler.Taler;
import de.andrena.schulung.spring.haendler.Ware;

public class Dieb {

	private Taler wertObergrenze;
	private Set<Ware> gestohleneWaren = new HashSet<Ware>();

	public Dieb(Taler wertObergrenze) {
		this.wertObergrenze = wertObergrenze;
	}

	public boolean kannBesorgen(Ware ware) {
		return !ware.preis().moreThan(wertObergrenze);
	}

	public void besorge(Ware ware) {
		gestohleneWaren.add(ware);
	}

	public void liefereAb(Ware ware, Haendler haendler) {
		haendler.kaufe(ware);
		gestohleneWaren.remove(ware);
	}
}
