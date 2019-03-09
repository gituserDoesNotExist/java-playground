package de.andrena.schulung.hibernate.uebung3.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

import de.andrena.schulung.hibernate.uebung3.dao.CompanyDao;
import de.andrena.schulung.hibernate.uebung3.dao.PersonDao;

public class AbstractDaoTest {

	protected EntityManager entityManager = Persistence.createEntityManagerFactory("DefaultPersistenceUnit")
			.createEntityManager();

	protected PersonDao personDao = new PersonDao();
	protected CompanyDao companyDao = new CompanyDao();

	@Before
	public void setUp() {
		personDao.setEntityManager(entityManager);
		companyDao.setEntityManager(entityManager);
		entityManager.getTransaction().begin();
	}

	@After
	public void tearDown() {
		entityManager.getTransaction().rollback();
	}

	protected void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}
}
