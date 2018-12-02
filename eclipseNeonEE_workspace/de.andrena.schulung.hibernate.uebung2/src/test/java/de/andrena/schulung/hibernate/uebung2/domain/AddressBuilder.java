package de.andrena.schulung.hibernate.uebung2.domain;

import de.andrena.schulung.hibernate.uebung2.domain.Address;

public class AddressBuilder {
	private Address address = new Address();

	public static AddressBuilder createAddress() {
		return new AddressBuilder();
	}

	public AddressBuilder withCity(String city) {
		address.setCity(city);
		return this;
	}

	public AddressBuilder withNumber(String number) {
		address.setNumber(number);
		return this;
	}

	public AddressBuilder withStreet(String street) {
		address.setStreet(street);
		return this;
	}

	public Address create() {
		return address;
	}
}
