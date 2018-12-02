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

import de.andrena.schulung.spring.haendler.Ware;
import de.andrena.schulung.spring.haendler.simple.EinfacherHaendler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/hehler-config.xml" })
public class HehlerTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private Hehler hehler;

	@Autowired
	private EinfacherHaendler einfacherHaendler;

	/*
	 * TODO Übung 1.06 (Import von Konfigurationsdateien): Lege eine Bean für
	 * einen Hehler in hehler-config.xml an. Importiere dazu die
	 * haendler-config.xml und verwende den Händler daraus als
	 * Konstruktorargument.
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
	 * TODO Übung 1.07 (Autowiring): Entferne das explizit angegebene
	 * Konstruktorargument für den Hehler und injiziere das Argument über die
	 * autowire-Funktion
	 */

	/*
	 * TODO Übung 1.08 (Scopes: singleton vs. prototype): Sorge dafür, dass
	 * Spring nicht dieselbe Bean für EinfacherHaendler herumreicht.
	 */
	@Test
	@DirtiesContext
	public void derHehlerUndDerEinfacheHaendlerSindNichtDieselbePersonUndTeilenSichKeineWaren() {
		Ware ware = create(ware("bronzener Haarreif").withPreis(taler(10)));
		hehler.kaufe(ware);
		assertThat(einfacherHaendler.angebot(), not(contains(ware)));
	}

	/*
	 * TODO Übung 1.10 (ApplicationContextAware): Erweitere die Klasse Hehler um
	 * das Interface ApplicationContextAware, und sorge dafür dass die Spelunke
	 * aus dem Context zugewiesen wird.
	 */
	@Test
	@DirtiesContext
	public void derHehlerBenoetigtEinenKompagnonUmWarenZuBesorgen() {
		Ware ware = create(ware("goldener Ring").withPreis(taler(120)));
		assertThat(hehler.kannBeschaffen(ware), is(true));
	}
}
