package org.builder;

import java.util.function.Function;

public class ValueAccessor<ENTITY> {

	private String attribute;
	private Function<ENTITY, String> function;

	public ValueAccessor(String name, Function<ENTITY, String> function) {
		this.attribute = name;
		this.function = function;
	}

	public String apply(ENTITY entity) {
		return function.apply(entity);
	}

	public String getAttribute() {
		return attribute;
	}

	public DifferenceContainer compare(ENTITY obj, ENTITY other) {
		if (obj == other || obj.equals(other)) {
			return DifferenceContainer.empty();
		}
		return new DifferenceContainer(attribute, apply(obj), apply(other));
	}

}
