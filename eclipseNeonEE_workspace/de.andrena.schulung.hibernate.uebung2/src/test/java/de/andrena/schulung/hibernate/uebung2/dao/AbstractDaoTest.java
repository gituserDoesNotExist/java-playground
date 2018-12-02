package de.andrena.schulung.hibernate.uebung2.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

import de.andrena.schulung.hibernate.uebung2.dao.BeerDao;
import de.andrena.schulung.hibernate.uebung2.dao.BottleDao;
import de.andrena.schulung.hibernate.uebung2.dao.FridgeDao;

public class AbstractDaoTest {

	protected EntityManager entityManager = Persistence.createEntityManagerFactory("DefaultPersistenceUnit")
			.createEntityManager();

	protected BeerDao beerDao = new BeerDao();
	protected BottleDao bottleDao = new BottleDao();
	protected FridgeDao fridgeDao = new FridgeDao();

	@Before
	public void setUp() {
		beerDao.setEntityManager(entityManager);
		bottleDao.setEntityManager(entityManager);
		fridgeDao.setEntityManager(entityManager);

		entityManager.getTransaction().begin();
	}

	@After
	public void tearDown() {
		if (entityManager.getTransaction().isActive())
			entityManager.getTransaction().rollback();
		entityManager.close();
	}

	protected void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}
}
