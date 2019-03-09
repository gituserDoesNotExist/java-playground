package de.andrena.schulung.hibernate.uebung2.domain;

import java.util.List;

import javax.persistence.OneToOne;

public class Fridge {

	private int volume;
	private String manufacturer;
	@OneToOne
	private Address address;
	private List<Bottle> bottles;
	private Long id;

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Bottle> getBottles() {
		return bottles;
	}

	public void setBottles(List<Bottle> bottles) {
		this.bottles = bottles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
