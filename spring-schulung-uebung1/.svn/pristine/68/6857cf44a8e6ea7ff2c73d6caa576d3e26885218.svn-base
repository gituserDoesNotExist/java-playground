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

import de.andrena.schulung.spring.haendler.Haendler;
import de.andrena.schulung.spring.haendler.Ware;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/test-config.xml" })
public class EinfacherHaendlerTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private Haendler haendler;

	/*
	 * TODO Übung 1.01 (Definition einer Bean): 
	 * Falls dir der Begriff "Dependency Injection" unbekannt ist, informiere dich vorab
	 * über dieses Entwurfsmuster. Eine gute Anlaufstelle ist: http://martinfowler.com/articles/injection.html
	 * Ansonsten können auch die Videos zu Spring hilfreich sein (siehe Wiki)
	 * 
	 * Lege in der haendler-config.xml eine
	 * Bean vom Typ EinfacherHaendler an!
	 */
	@Test
	@DirtiesContext
	public void gekaufteWareWirdWiederAngeboten() {
		Ware ware = create(ware("rostiges Schwert"));
		haendler.kaufe(ware);
		assertThat(haendler.angebot(), contains(ware));
	}

	/*
	 * TODO Übung 1.02 (Konstruktorargumente setzen / Werte angeben): Erweitere
	 * die Bean um ein Konstruktorargument, welches ein Startgeld vom 200 Talern
	 * setzt.
	 */
	@Test
	@DirtiesContext
	public void preisDerGekauftenWareWirdVomVermoegenAbgezogen() {
		Ware ware = create(ware("rostiges Schwert").withPreis(taler(20)));
		haendler.kaufe(ware);
		assertThat(haendler.vermoegen(), is(taler(180)));
	}

	/*
	 * TODO Übung 1.03 (Setter Injection): Lege eine weitere Bean vom Typ
	 * FraudDetectingHaendlerListener an, und setze diese in die
	 * Listener-Property des Händlers.
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
	 * TODO Übung 1.04 (Injection von Collections): Erstelle eine Bean der Klasse
	 * ProfitCreatingHaendlerListener. Diese muss so konfiguriert werden, dass
	 * er den Preis einer Ware um 10% plus 1 Taler erhöht.
	 * 
	 * Injiziere diese Bean zusammen mit dem FraudDetectingHaendlerListener dem
	 * EinfachenHaendler als Liste.
	 */
	@Test
	@DirtiesContext
	public void gekaufteWareWirdMit10ProzentPlusEinTalerGewinnVerkauft() {
		Ware ware = create(ware("rostiges Schwert").withPreis(taler(20)));
		haendler.kaufe(ware);
		haendler.verkaufe(ware);
		assertThat(haendler.vermoegen(), is(taler(203)));
	}

	/*
	 * TODO Übung 1.05 (PropertyPlaceholderConfigurer): Erstelle eine
	 * PropertyPlaceholderConfigurer-Bean und gebe diesem die Properties-Datei
	 * haendler.properties mit. Verwende anstelle der hart konfigurierten Werte
	 * in der haendler-config.xml Platzhalter für die Properties aus der Datei.
	 */
}
