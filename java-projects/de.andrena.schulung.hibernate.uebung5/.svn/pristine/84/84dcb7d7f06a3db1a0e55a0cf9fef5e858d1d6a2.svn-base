package de.andrena.schulung.hibernate.uebung5.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Person extends BaseEntity {

	private String name;

	private Integer age;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "drinker")
	private List<Beer> beers = new ArrayList<>();

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void addBeer(Beer beer) {
		beers.add(beer);
		beer.setDrinker(this);
	}

	public List<Beer> getBeers() {
		return beers;
	}

}
