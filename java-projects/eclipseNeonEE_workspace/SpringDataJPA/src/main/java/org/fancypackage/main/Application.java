package org.fancypackage.main;

import javax.persistence.EntityManager;

import org.fancypackage.model.MyEntity;
import org.fancypackage.persistence.MyEntityRepository;

public class Application {

	public static void main(String[] args) {
		ContextHandler handler = new ContextHandler();
		handler.printAllBeans();

		MyEntityRepository repository = handler.getApplicationContext().getBean(MyEntityRepository.class);
		EntityManager entityManager = handler.getApplicationContext().getBean(EntityManager.class);

		MyEntity myEntity = new MyEntity();
		myEntity.setId(1);
		myEntity.setName("firstname");
		myEntity.setWebsite("www.example.com");
		myEntity.setFieldSuperclass("superclassField");

		long savedId = repository.save(myEntity).getId();
		entityManager.detach(myEntity);

		MyEntity retrieved = repository.findById(savedId);
		System.out.println(retrieved.getId());
		retrieved.setName("new name");
		repository.save(retrieved);
		entityManager.detach(retrieved);

	}

}