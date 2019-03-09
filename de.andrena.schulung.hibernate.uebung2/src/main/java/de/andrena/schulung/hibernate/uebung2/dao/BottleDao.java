package de.andrena.schulung.hibernate.uebung2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import de.andrena.schulung.hibernate.uebung2.domain.Beer;
import de.andrena.schulung.hibernate.uebung2.domain.Bottle;

public class BottleDao {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void saveBottle(Bottle bottle) {
		entityManager.persist(bottle);
	}

	public List<Bottle> findByBeer(Beer beer) {
		return null;
	}

	public Bottle findById(Long id) {

		return null;
	}

}
