package de.andrena.schulung.hibernate.uebung2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import de.andrena.schulung.hibernate.uebung2.domain.Beer;

public class BeerDao {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void saveBeer(Beer beer) {
		entityManager.persist(beer);
	}

	public List<Beer> findByBrewery(String brewery) {
		return null;
	}

}
