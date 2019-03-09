package org.fancypackage.model;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

@MappedSuperclass
@Audited
public class BaseEntity {

	@Id
	@GeneratedValue
	private long id;

	@Version
	private LocalDateTime lastModified;

	private String field1Superclass;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getField1Superclass() {
		return field1Superclass;
	}

	public void setFieldSuperclass(String field1Superclass) {
		this.field1Superclass = field1Superclass;
	}

}
