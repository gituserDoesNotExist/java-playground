package de.andrena.schulung.spring.haendler.hehler;

import static de.andrena.schulung.spring.haendler.Taler.taler;
import static de.andrena.schulung.spring.haendler.WareBuilder.create;
import static de.andrena.schulung.spring.haendler.WareBuilder.ware;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.andrena.schulung.spring.config.TestConfiguration;
import de.andrena.schulung.spring.haendler.Ware;
import de.andrena.schulung.spring.haendler.simple.EinfacherHaendler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfiguration.class})
public class HehlerTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private Hehler hehler;

	@Autowired
	private EinfacherHaendler einfacherHaendler;

	/*
	 * TODO Übung 2.05 (Konstruktor-Injection): Annotiere den Hehler als
	 * Spring-Bean und injiziere den Haendler im Konstruktor.
	 */
	@Test
	@DirtiesContext
	public void einHehlerKannWieEinEinfacherHaendlerWarenKaufenUndVerkaufen() {
		Ware ware = create(ware("bronzener Haarreif").withPreis(taler(10)));
		hehler.kaufe(ware);
		hehler.verkaufe(ware);
		assertThat(hehler.vermoegen(), is(taler(202)));
	}

	/*
	 * TODO Übung 2.06 (Scopes: singleton vs. prototype): Sorge dafür, dass
	 * Spring nicht dieselbe Bean für EinfacherHaendler herumreicht. Benutze
	 * dafür die @Scope-Annotation
	 */
	@Test
	@DirtiesContext
	public void derHehlerUndDerEinfacheHaendlerSindNichtDieselbePersonUndTeilenSichKeineWaren() {
		Ware ware = create(ware("bronzener Haarreif").withPreis(taler(10)));
		hehler.kaufe(ware);
		assertThat(einfacherHaendler.angebot(), not(contains(ware)));
	}

	/*
	 * TODO Übung 2.08 (ApplicationContextAware): Hinweis: Vor dieser Aufgabe muss Aufgabe
	 * 2.07 gelöst werden. Diese befindet sich in der Klasse "SpelunkeTest".
	 * Injiziere den ApplicationContext in die Hehler-Komponente und sorge dafür,
	 * dass die Spelunke aus dem Context zugewiesen wird (z.B. über eine init-Methode mit
	 * korrekter Annotation)
	 */
	@Test
	@DirtiesContext
	public void derHehlerBenoetigtEinenKompagnonUmWarenZuBesorgen() {
		Ware ware = create(ware("goldener Ring").withPreis(taler(120)));
		assertThat(hehler.kannBeschaffen(ware), is(true));
	}
}
