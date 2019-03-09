/*
 * Created on 30.08.2018
 *
 * Dimensions - Versionierung
 * $Workfile: %PM% $
 * $Revision: %PR% $
 * $Date: %Date% $
 * $Author: %Author% $
 * 
 * (c) Copyright SV Informatik GmbH 2010
 */

package de.any.crawl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class PatternMatcher {
  
  /**
   * 
   * @param searchPattern
   * @param searchString
   * @param groupNumber Nummer der Gruppe. groupNumber=0 holt alle Treffer.
   * @return Extrahiert einen String aus einem Suchstring der ein bestimmtes Pattern erfüllt. Falls nichts gefunden wird, wird ein leerer String zurückgegeben.
   */
  public static String extractGroupFromStringMatchingPattern(String searchPattern, String searchString, int groupNumber) {
    Pattern pattern = Pattern.compile(searchPattern);
    Matcher matcher = pattern.matcher(searchString);
    if (matcher.find()) {
      return matcher.group(groupNumber);
    }
    return "";
  }
  
  /**
   * 
   * @param searchPattern
   * @param searchString
   * @return Extrahiert einen String aus einem Suchstring der ein bestimmtes Pattern erfüllt. Falls nichts gefunden wird, wird ein leerer String zurückgegeben.
   */
  public static String extractGroupFromStringMatchingPattern(String searchPattern, String searchString) {
    return extractGroupFromStringMatchingPattern(searchPattern, searchString, 0);
  }
  
}
