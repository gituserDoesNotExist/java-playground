package de.andrena.schulung.spring.haendler;

import java.util.Set;

public interface Haendler {

	public abstract void kaufe(Ware ware);

	public abstract void verkaufe(Ware ware);

	public abstract Set<Ware> angebot();

	public abstract Taler vermoegen();

}