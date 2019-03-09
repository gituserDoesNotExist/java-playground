package de.andrena.schulung.spring.haendler.simple.listeners;

import static de.andrena.schulung.spring.haendler.Taler.taler;

import java.math.BigDecimal;

import de.andrena.schulung.spring.haendler.Haendler;
import de.andrena.schulung.spring.haendler.Taler;
import de.andrena.schulung.spring.haendler.Ware;
import de.andrena.schulung.spring.haendler.simple.HaendlerListener;

public class ProfitCreatingHaendlerListener implements HaendlerListener {

	private BigDecimal factor = BigDecimal.ONE;

	private int addend = 0;

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public void setAddend(int addend) {
		this.addend = addend;
	}

	public void beforeKauf(Haendler haendler, Ware ware) {

	}

	public void afterKauf(Haendler haendler, Ware ware) {
		Taler newPreis = ware.preis().mal(factor).plus(taler(addend));
		ware.setPreis(newPreis);
	}

	public void beforeVerkauf(Haendler haendler, Ware ware) {

	}

	public void afterVerkauf(Haendler haendler, Ware ware) {
	}

}
