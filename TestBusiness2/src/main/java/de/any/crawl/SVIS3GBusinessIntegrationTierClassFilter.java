/*
 * Created on 29.08.2018
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
 * @author N0008244
 */
public class SVIS3GBusinessIntegrationTierClassFilter implements QualifiedClassFilter {
  
  private static final String BASE_PACKAGE_SVIS = "de.svi.svis3g";
  
  @Override
  public boolean isClassQualified(String classname) {
    boolean qualified = true;
    qualified &= isSvisClass(classname);
    qualified &= !classnameContainsTest(classname);
    qualified &= !classContainsInnerClass(classname);
    qualified &= !isClassFromPresentationTier(classname);
    return qualified;
  }
  
  private boolean isClassFromPresentationTier(String classname) {
    return classname.contains("presentation") || classname.contains("faces");
  }
  
  private boolean isSvisClass(String classname) {
    return classname.startsWith(BASE_PACKAGE_SVIS);
  }
  
  private boolean classnameContainsTest(String classname) {
    return classname.matches(".*\\..*Test.*");
  }
  
  private boolean classContainsInnerClass(String classname) {
    return classname.contains("$");
  }
  
}
