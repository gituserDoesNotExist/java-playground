package de.andrena.schulung.spring.haendler.hehler;

public class ZwielichtigeGestalt {
	private Object object;

	public ZwielichtigeGestalt(String bezeichnung) {
		this(new Object());
	}

	public ZwielichtigeGestalt(Object object) {
		this.object = object;
	}

	public boolean isA(Class<?> clazz) {
		return clazz.isAssignableFrom(object.getClass());
	}

	public Object enthuelle() {
		return object;
	}
}