package de.andrena.schulung.spring.haendler.simple;

import static de.andrena.schulung.spring.haendler.Taler.taler;
import static java.util.Collections.unmodifiableSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.andrena.schulung.spring.haendler.Haendler;
import de.andrena.schulung.spring.haendler.Taler;
import de.andrena.schulung.spring.haendler.Ware;

public class EinfacherHaendler implements Haendler {

	private Set<Ware> waren = new HashSet<Ware>();
	private Taler vermoegen;
	private HaendlerListener listener = new HaendlerListeners();

	public EinfacherHaendler() {
		this(0);
	}

	public EinfacherHaendler(int anzahlTaler) {
		vermoegen = taler(anzahlTaler);
	}

	public void setListener(List<HaendlerListener> listeners) {
		this.listener = new HaendlerListeners(listeners);
	}

	public void kaufe(Ware ware) {
		listener.beforeKauf(this, ware);
		waren.add(ware);
		vermoegen = vermoegen.minus(ware.preis());
		listener.afterKauf(this, ware);
	}

	public void verkaufe(Ware ware) {
		listener.beforeVerkauf(this, ware);
		waren.remove(ware);
		vermoegen = vermoegen.plus(ware.preis());
		listener.afterVerkauf(this, ware);
	}

	public Set<Ware> angebot() {
		return unmodifiableSet(waren);
	}

	public Taler vermoegen() {
		return vermoegen;
	}
}
