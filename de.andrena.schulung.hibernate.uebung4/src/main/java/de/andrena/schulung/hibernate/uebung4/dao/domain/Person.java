package de.andrena.schulung.hibernate.uebung4.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="PASSPORT_NR", nullable=false)
	private String passportNumber;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="AGE", nullable=false)
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private Activity activity;

	@Column(name="email", nullable=true)
	private String emailadresse;
	
	public Person() {
	}
	
	public Person(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity taetigkeit) {
		this.activity = taetigkeit;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getEmailadresse() {
		return emailadresse;
	}

	public void setEmailadresse(String emailadresse) {
		this.emailadresse = emailadresse;
	}
}
