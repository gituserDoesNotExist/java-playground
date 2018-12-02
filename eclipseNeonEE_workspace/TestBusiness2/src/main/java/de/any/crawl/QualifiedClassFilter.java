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

/**
 * Zweck dieser Klasse: <br>
 * Entscheidet, ob eine Klasse qualifiziert ist, d.h. vom {@link ClasspathScanner} aufgenommen werden soll oder nicht.
 * 
 * @author N0008244
 */
public interface QualifiedClassFilter {
  
  /**
   * @param classname
   * @return true wenn eine Klasse qualifiziert ist.
   */
  boolean isClassQualified(String classname);
  
}
