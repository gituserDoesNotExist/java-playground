package de.andrena.schulung.spring.haendler.hehler;

import static de.andrena.schulung.spring.haendler.Taler.taler;
import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Spelunke {

	private List<ZwielichtigeGestalt> gaeste = new ArrayList<ZwielichtigeGestalt>();
	private List<Dieb> diebe = new ArrayList<Dieb>();

	public Spelunke() {
		gaeste.add(new ZwielichtigeGestalt("Trinker"));
		gaeste.add(new ZwielichtigeGestalt("Meuchelmörder"));
		gaeste.add(new ZwielichtigeGestalt(new Dieb(taler(50))));
		gaeste.add(new ZwielichtigeGestalt("Ork"));
		gaeste.add(new ZwielichtigeGestalt(new Dieb(taler(200))));
		gaeste.add(new ZwielichtigeGestalt(""));
		gaeste.add(new ZwielichtigeGestalt(new Dieb(taler(3000))));
		gaeste.add(new ZwielichtigeGestalt("Trinker"));
	}

	public void identifiziereDiebe() {
		diebe.clear();
		for (ZwielichtigeGestalt gast : gaeste)
			if (gast.isA(Dieb.class))
				diebe.add((Dieb) gast.enthuelle());
	}

	public List<Dieb> nenneDiebe() {
		return unmodifiableList(diebe);
	}

}
