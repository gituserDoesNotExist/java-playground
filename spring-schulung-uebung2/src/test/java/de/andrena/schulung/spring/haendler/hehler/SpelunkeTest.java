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

import de.andrena.schulung.spring.config.TestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfiguration.class})
public class SpelunkeTest {

	@Autowired
	private Spelunke spelunke;

	/*
	 * TODO Übung 2.07 (init-method): Annotiere die Klasse Spelunke als
	 * Spring-Komponente und sorge über die Annotation @PostConstruct dafür, 
	 * dass die Liste der Diebe initialisiert wird.
	 */
	@Test
	@DirtiesContext
	public void spelunkeHatDiebeIdentifiziert() {
		assertThat(spelunke.nenneDiebe(), is(not(empty())));
	}
}
