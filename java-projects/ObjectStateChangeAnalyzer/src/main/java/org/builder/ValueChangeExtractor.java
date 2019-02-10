package org.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValueChangeExtractor<ENTITY> {

	private List<ValueAccessor<ENTITY>> fields = new ArrayList<>();

	public void addField(ValueAccessor<ENTITY> accessor) {
		fields.add(accessor);
	}

	public List<DifferenceContainer> extractChanges(ENTITY obj, ENTITY other) {
		if (fields.size() == 0) {
			return new ArrayList<>();
		}
		return fields.stream().map(accessor -> accessor.compare(obj, other))
				.filter(container -> !container.getAttribute().equals("empty")).collect(Collectors.toList());

	}

}
