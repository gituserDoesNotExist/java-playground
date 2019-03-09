package de.andrena.schulung.hibernate.uebung5.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Beer extends BaseEntity {

	private String name;

	@ManyToOne
	private Person drinker;

	public Beer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getDrinker() {
		return drinker;
	}

	public void setDrinker(Person drinker) {
		this.drinker = drinker;
	}

}
