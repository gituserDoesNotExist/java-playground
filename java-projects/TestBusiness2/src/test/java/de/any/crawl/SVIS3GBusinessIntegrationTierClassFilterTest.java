package de.any.crawl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
public class SVIS3GBusinessIntegrationTierClassFilterTest {
  
  private SVIS3GBusinessIntegrationTierClassFilter selector = new SVIS3GBusinessIntegrationTierClassFilter();
  
  @Test
  @SuppressWarnings("javadoc")
  public void isClassQualified() {
    assertFalse(selector.isClassQualified("de.svi.svis3g.presentation.AnyClass"));
    assertFalse(selector.isClassQualified("de.svi.svis3g.business.SomeTestClass"));
    assertFalse(selector.isClassQualified("de.svi.svis3g.business.MyTest"));
    assertFalse(selector.isClassQualified("de.svi.svis3g.faces.ElResolver"));
    assertFalse(selector.isClassQualified("de.svi.svis3g.MyClassContainingInnerClass$1"));
    
    assertTrue(selector.isClassQualified("de.svi.svis3g.business.BusinessClass"));
  }
  
}
