package de.andrena.schulung.hibernate.uebung5.dao;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.andrena.schulung.hibernate.uebung5.domain.BaseEntity;
import de.andrena.schulung.hibernate.uebung5.domain.Beer;

@Named
public class BeerDaoImpl implements BeerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(BaseEntity beer) {
		entityManager.persist(beer);
	}

	@Override
	public BaseEntity findById(long id) {
		return entityManager.find(Beer.class, id);
	}

	@Override
	public void flush() {
		entityManager.flush();
	}
}
