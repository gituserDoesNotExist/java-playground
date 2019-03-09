package de.andrena.schulung.spring.haendler.simple;

import static java.util.Collections.emptyList;

import java.util.List;

import de.andrena.schulung.spring.haendler.Haendler;
import de.andrena.schulung.spring.haendler.Ware;

public class HaendlerListeners implements HaendlerListener {

	private List<HaendlerListener> listeners;

	public HaendlerListeners() {
		this.listeners = emptyList();
	}

	public HaendlerListeners(List<HaendlerListener> listeners) {
		this.listeners = listeners;
	}

	public void beforeKauf(Haendler haendler, Ware ware) {
		for (HaendlerListener listener : listeners)
			listener.beforeKauf(haendler, ware);
	}

	public void afterKauf(Haendler haendler, Ware ware) {
		for (HaendlerListener listener : listeners)
			listener.afterKauf(haendler, ware);
	}

	public void beforeVerkauf(Haendler haendler, Ware ware) {
		for (HaendlerListener listener : listeners)
			listener.beforeVerkauf(haendler, ware);
	}

	public void afterVerkauf(Haendler haendler, Ware ware) {
		for (HaendlerListener listener : listeners)
			listener.afterVerkauf(haendler, ware);
	}

}
