package de.andrena.schulung.hibernate.uebung5.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	@Override
	public final int hashCode() {
		return 1;
	}

	@Override
	public final boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (getId() == 0) {
			// Only same are equal if no id
			return false;
		}
		return getClass().isInstance(other) && getId() == ((BaseEntity) other).getId();
	}

}
