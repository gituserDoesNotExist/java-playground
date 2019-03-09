package de.andrena.schulung.spring.haendler.simple;

import de.andrena.schulung.spring.haendler.Haendler;
import de.andrena.schulung.spring.haendler.Ware;

public interface HaendlerListener {

	void beforeKauf(Haendler haendler, Ware ware);

	void afterKauf(Haendler haendler, Ware ware);

	void beforeVerkauf(Haendler haendler, Ware ware);

	void afterVerkauf(Haendler haendler, Ware ware);

}
