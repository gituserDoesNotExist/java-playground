package de.andrena.schulung.hibernate.uebung2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import de.andrena.schulung.hibernate.uebung2.domain.Fridge;

public class FridgeDao {

	private EntityManager entityManager;

	public void saveFridge(Fridge fridge) {
		entityManager.persist(fridge);
	}

	public List<Fridge> findBy(FridgeSearchDto searchDto) {
		return null;
	}

	public Fridge findById(Long id) {
		return entityManager.find(Fridge.class, id);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
