package de.andrena.schulung.hibernate.uebung4.dao;

import static de.andrena.schulung.hibernate.uebung4.dao.ConstraintViolationExceptionMatcher.containsMessages;
import static de.andrena.schulung.hibernate.uebung4.dao.domain.Activity.IM_BERUFSLEBEN;
import static de.andrena.schulung.hibernate.uebung4.dao.domain.Activity.KINDERGARTEN;
import static de.andrena.schulung.hibernate.uebung4.domain.PersonBuilder.createPerson;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.andrena.schulung.hibernate.uebung4.dao.domain.Activity;
import de.andrena.schulung.hibernate.uebung4.dao.domain.EntityValidationException;
import de.andrena.schulung.hibernate.uebung4.dao.domain.Person;

public class ValidierePersonTest extends AbstractDaoTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// TODO Übung 4 Aufgabe 1: (Validierung im Java-Code mit PrePersist)
	// Die Tätigkeit einer Person muss zu ihrem Alter passen.
	// Verwende die @PrePersist-Annotation, um in der Klasse "Person" eine
	// Methode zu kennzeichnen, die vor dem Speichern ausgeführt werden soll.
	// Ergänze die fehlende Implementierung im Java-Code.
	// Tip: Verwende die Methoden aus der Klasse "Activity" um zu prüfen, dass
	// die Tätigkeit der Person zu ihrem Alter passt.
	@Test
	public void validatePersonBeforePersisting() {
		Person person = createPerson().withName("Stefan").withTaetigkeit(KINDERGARTEN).withAge(8).withPassportNumber("0815").create();

		expectedException.expect(EntityValidationException.class);
		expectedException.expectMessage("8");
		expectedException.expectMessage("KINDERGARTEN");
		personDao.savePerson(person);
	}

	// TODO Übung 4 Aufgabe 2: (Test der Validierung mit PrePersist)
	// Wo würdest du die Validierung aus der vorherigen Übung testen? Und wieso?
	// Was sind die Vor- und Nachteile?
	//
	// A) Gar nicht. Ich mache keine Fehler.
	// B) Alle im DAOTest
	// C) Alle in der Testklasse für die Entity
	// D) Im DAO Test und in der Entity
	//
	// Verändert sich deine Antwort wenn die Validierung komplexer wird?
	//
	//
	// Was passiert bei folgendem Beispiel:
	// Eine Person hat mehrere Haustiere. Die Haustiere werden beim Speichern
	// einer Person automatisch mitgespeichert. Die Klasse "Haustier" hat eine
	// Validierungsmethode mit @PrePersist-Annotation. Würde die Validierung des
	// Haustiers mit @PrePersist auch beim Speichern der Person greifen?
	//
	// [ ] Ja
	// [ ] Nein
	//
	// Falls du dir nicht sicher bist, probiere es doch einfach aus!

	@Test
	public void validiereHaustiereBeimSpeichern() {
		createPerson().withName("Stefan").withTaetigkeit(Activity.IM_BERUFSLEBEN).withAge(20).withPassportNumber("0815").create();
		// Hier kannst du die Validierung mit den Haustieren ausprobieren
	}

	// TODO Übung 4 Aufgabe 3: (Unique Constraints)
	// Die Ausweisnummer muss einen Bürger eindeutig identifizieren können. Löse
	// die Aufgabe mit einer JPA-Annotation.
	@Test
	public void passportNumberMustBeUnique() {
		Person stefan = createPerson().withName("Stefan").withTaetigkeit(IM_BERUFSLEBEN).withAge(32).withPassportNumber("0815").create();
		personDao.savePerson(stefan);
		Person joachim = createPerson().withName("Joachim").withTaetigkeit(IM_BERUFSLEBEN).withAge(35).withPassportNumber("0815").create();

		expectedException.expect(javax.persistence.PersistenceException.class);
		personDao.savePerson(joachim);
		flushAndClear();
	}

	// TODO Übung 4 Aufgabe 4: (Maximale Länge für String)
	// Die Ausweisnummer darf maximal 10 Zeichen lang sein. Löse die Aufgabe mit
	// einer JPA-Annotation.
	@Test
	public void passportNumberMustMaxLengthIs10() {
		Person stefan = createPerson().withName("Stefan").withTaetigkeit(IM_BERUFSLEBEN).withAge(32).withPassportNumber("0123456789A").create();

		expectedException.expect(PersistenceException.class);
		personDao.savePerson(stefan);
		flushAndClear();
	}

	// TODO Übung 4 Aufgabe 5: (JSR-349 BeanValidation - Validierung einer
	// Email-Adresse)
	// Die Emailadresse muss syntaktisch korrekt sein.
	// Recherchiere was JSR-349 ist. Verwende eine JSR-349-Annotation, um die
	// Email-Adresse zu validieren.
	@Test
	public void emailMustBeCorrect() {
		Person stefan = createPerson().withName("Stefan").withTaetigkeit(IM_BERUFSLEBEN).withAge(32).withPassportNumber("0123456789").withEmail("asw")
				.create();

		expectedException.expect(ConstraintViolationException.class);
		personDao.savePerson(stefan);
		flushAndClear();
	}

	// TODO Übung 4 Aufgabe 6: (JSR-349 BeanValidation - Validierung der Länge
	// eines Strings)
	// Der Name der Person muss mindestens 3 und höchsten 50 Zeichen lang sein.
	// Verwende eine JSR-349-Annotation, um die die Länge des Namens zu
	// validieren.
	@Test
	public void nameMustNotBeTooShort() {
		Person stefan = createPerson().withName("St").withTaetigkeit(IM_BERUFSLEBEN).withAge(32).withPassportNumber("0123456789").create();

		expectedException.expect(ConstraintViolationException.class);
		expectedException.expect(containsMessages("muss zwischen 3 und 50 liegen"));
		personDao.savePerson(stefan);
		flushAndClear();
	}

	// TODO Übung 4 Aufgabe 7: (Validierungsmöglichkeiten bei JSR-349)
	// Schaue dir die Validierungsmöglichkeiten von JSR-349 an. Wie würdest du
	// deine JSR-349 Annotationen testen? Welche Vor- und Nachteile haben die
	// verschiedenen Möglichkeiten?
	//
	// A) Gar nicht. Ich teste nur Java Code.
	// B) Alle Annotationen im DAOTest
	// C) Alle in der Testklasse für die Entity (Geht das überhaupt?
	// Ausprobieren?)
	// D) Im DAOTest und in der Testklasse für die Entity
	//

	// TODO Übung 4 Aufgabe 8: (Vor- und Nachteile der Validierungmöglichkeiten)
	// Du hast verschiedene Möglichkeit der Validierung für Entities
	// kennengelernt. Überlege dir was die Vor- und Nachteile der verschiedenen
	// Möglichkeiten sind.

}
