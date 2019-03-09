package de.andrena.schulung.spring.haendler.hehler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/hehler-config.xml" })
public class SpelunkeTest {

	@Autowired
	private Spelunke spelunke;

	/*
	 * TODO Übung 1.09 (init-method): Erstelle eine Bean für die Spelunke und
	 * sorge dafür, dass beim Hochfahren des ApplicationContext die Methode
	 * identifiziereDiebe() aufgerufen wird.
	 */
	@Test
	@DirtiesContext
	public void spelunkeHatDiebeIdentifiziert() {
		assertThat(spelunke.nenneDiebe(), is(not(empty())));
	}
}
