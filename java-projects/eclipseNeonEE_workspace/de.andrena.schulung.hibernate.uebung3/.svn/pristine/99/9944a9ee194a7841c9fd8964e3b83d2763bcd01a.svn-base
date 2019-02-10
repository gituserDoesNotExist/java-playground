package de.andrena.schulung.hibernate.uebung3.dao;

import javax.persistence.EntityManager;

import de.andrena.schulung.hibernate.uebung3.domain.Company;

public class CompanyDao {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Company saveCompany(Company company) {
		entityManager.persist(company);
		return company;
	}

	public Company findById(Long id) {
		return null;
	}

	// Diese Methode ist nur für Demonstrationszwecke. In einer Anwendung gibt
	// es zunächst keinen Grund für eine derartige Methode.
	public Company findByIdWithClear(Long id) {
		return null;
	}

}
