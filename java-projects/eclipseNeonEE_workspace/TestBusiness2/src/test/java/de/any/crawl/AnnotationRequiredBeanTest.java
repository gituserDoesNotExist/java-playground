package de.any.crawl;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.junit.Test;

/**
 * Zweck dieser Klasse: <br>
 * (Hier Zweck eintragen - bis zu 2 Zeilen).
 * <p>
 * Angewandte Pattern: <br>
 * (Hier Pattern nennen)
 * <p>
 * Zusammenhaenge / Partnerklassen <br>
 * (Hier erlaeutern)
 * <p>
 * Abgrenzung zu anderen Klassen <br>
 * (Hier erlaeutern)
 * <p>
 * Weitere Informationen <br>
 * (Hier auffuehren)
 * 
 * @author N0008244
 */
public class AnnotationRequiredBeanTest {

	@Test
	@SuppressWarnings("javadoc")
	public void create_FirstCharacterConvertedToLowerCase() {
		AnnotationRequiredBean result = new AnnotationRequiredBean(AnnotationRequiredBeanTest.class);

		assertThat(result.getBeanId(), equalTo("annotationRequiredBeanTest"));
	}

	@Test
	@SuppressWarnings("javadoc")
	public void getDescriptionForXmlConfiguration() {
		AnnotationRequiredBean bean = new AnnotationRequiredBean(AnnotationRequiredBeanTest.class);

		Element element = bean.getDescriptionForXmlConfiguration();

		assertThat(convertElementToString(element), equalTo("<bean class=\"" + AnnotationRequiredBeanTest.class.getName() + "\" />"));
	}

	public String convertElementToString(Element element) {
		return new XMLOutputter().outputString(element);
	}

}
