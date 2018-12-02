package de.andrena.schulung.hibernate.uebung3.dao;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.andrena.schulung.hibernate.uebung3.domain.Company;
import de.andrena.schulung.hibernate.uebung3.domain.Person;
import de.andrena.schulung.hibernate.uebung3.domain.PersonBuilder;

public class LazyLoadingTest extends AbstractDaoTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// TODO Übung 3 Aufgabe 6: (Lazy Loading)
	// Eine Möglichkeit, um das Laden von Objekten zu beschränken, ist das Lazy
	// Loading. Dabei werden gewisse Daten in Objekten nur bei Bedarf
	// nachgeladen. Im konkreten Fall werden die Mitarbeiter der Firma erst beim
	// Zugriff auf die Liste von Hibernate aus der Datenbank geladen. Im
	// Debug-Modus kann man sich das Objekt anschauen und erkennen, dass es sich
	// NICHT um eine gewöhnliche ArrayList handelt.
	@Test
	public void testLazyLoading() throws Exception {
		Company company = createCompany();

		companyDao.saveCompany(company);
		Long id = company.getId();

		flushAndClear();

		Company savedCompany = companyDao.findById(id);
		// Lazy Loading
		List<Person> employee = savedCompany.getEmployee();
		Assert.assertThat(employee.size(), CoreMatchers.is(2));
	}

	// TODO Übung 3 Aufgabe 7: (Lazy Loading nach beendeter Transaktion)
	// Hier ist eine der Stolperfallen bei Lazy Loading aufgezeigt. Damit
	// Hibernate die Daten später nachladen kann, muss das Objekt noch mit der
	// Session verbunden sein. Ansonsten gibt es die in diesem Test erwartete
	// Exception.
	@Test
	public void testLazyLoadingException() throws Exception {
		Company company = createCompany();

		companyDao.saveCompany(company);
		Long id = company.getId();

		flushAndClear();

		Company savedCompany = companyDao.findByIdWithClear(id);

		expectedException.expect(LazyInitializationException.class);
		// Lazy Loading
		List<Person> employee = savedCompany.getEmployee();
		Assert.assertThat(employee.size(), CoreMatchers.is(2));
	}

	// TODO Übung 3 Aufgabe 8: (Lazy Loading - N+1-Problem)
	// Was sind die Probleme bei Lazy Loading neben dem Offenhalten der Session?
	// Wie kann es zu dem songenannten N+1-Problem kommen? Was sind Strategien
	// um die Problematik zu vermeiden?
	private Company createCompany() {
		Company company = new Company();
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(new PersonBuilder().withName("Peter").create());
		people.add(new PersonBuilder().withName("Hans").create());
		company.setEmployee(people);
		return company;
	}
}
