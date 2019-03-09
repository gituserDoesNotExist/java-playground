package org.fancypackage.persistence;

import org.fancypackage.model.MyEntity;
import org.springframework.data.repository.Repository;

public interface MyEntityRepository extends Repository<MyEntity, Long> {

	MyEntity save(MyEntity myEntity);

	MyEntity findById(long id);

}
