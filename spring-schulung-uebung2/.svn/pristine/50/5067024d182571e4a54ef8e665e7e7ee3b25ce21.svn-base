package de.andrena.schulung.spring.haendler.simple;

import static de.andrena.schulung.spring.haendler.Taler.taler;
import static de.andrena.schulung.spring.haendler.WareBuilder.create;
import static de.andrena.schulung.spring.haendler.WareBuilder.ware;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfiguration.class})
public class EinfacherHaendlerTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private EinfacherHaendler haendler;

	/*
	 * TODO Übung 2.01 (Definition einer Bean mit Annotationen): Annotiere die
	 * Bean EinfacherHaendler als Spring-Komponente.
	 */
	@Test
	@DirtiesContext
	public void gekaufteWareWirdWiederAngeboten() {
		Ware ware = create(ware("rostiges Schwert"));
		haendler.kaufe(ware);
		assertThat(haendler.angebot(), contains(ware));
	}

	/*
	 * TODO Übung 2.02 (Konstruktorargumente setzen / Werte angeben): Nutze die
	 * Annotationen @Autowired und @Value so, dass das Startgeld aus der Datei
	 * haendler.properties genommen wird.
	 */
	@Test
	@DirtiesContext
	public void preisDerGekauftenWareWirdVomVermoegenAbgezogen() {
		Ware ware = create(ware("rostiges Schwert").withPreis(taler(20)));
		haendler.kaufe(ware);
		assertThat(haendler.vermoegen(), is(taler(180)));
	}

	/*
	 * TODO Übung 2.03 (Field Injection): Annotiere die Klasse
	 * FraudDetectingHaendlerListener als Spring-Komponente, und injecte diese
	 * mit Hilfe von @Autowired in das Listener-Feld des Händlers.
	 */
	@Test
	@DirtiesContext
	public void zuTeureWareKannNichtGekauftWerden() {
		Ware ware = create(ware("goldenes Amulett").withPreis(taler(500)));
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(containsString("too expensive"));
		haendler.kaufe(ware);
	}

	/*
	 * TODO Übung 2.04 (Injection von Collections): Annotiere den
	 * ProfitCreatingHaendlerListener als Spring-Komponente, und sorge dafür
	 * dass er die Properties aus der Datei haendler.properties auflöst.
	 */
	@Test
	@DirtiesContext
	public void gekaufteWareWirdMit10ProzentPlusEinTalerGewinnVerkauft() {
		Ware ware = create(ware("rostiges Schwert").withPreis(taler(20)));
		haendler.kaufe(ware);
		haendler.verkaufe(ware);
		assertThat(haendler.vermoegen(), is(taler(203)));
	}

}
