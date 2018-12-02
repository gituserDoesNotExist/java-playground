package de.any.crawl;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class PatternMatcherTest {
  
  private static final String REGEX_PATTERN = "(file:\\\\)(.*\\.jar)";
  private static final String SEARCH_STRING = "file:\\B:\\MavenRepo\\de\\svi\\svis3g\\AnredeModul\\3.17.0-SNAPSHOT\\AnredeModul-3.17.0-SNAPSHOT.jar!\\META-INF";
  
  @Test
  public void extractGroupFromStringMatchingPattern_NoGroup() {
    String searchString = SEARCH_STRING;
    
    String result = PatternMatcher.extractGroupFromStringMatchingPattern(REGEX_PATTERN, searchString, 0);
    
    assertThat(result, IsEqual.equalTo("file:\\B:\\MavenRepo\\de\\svi\\svis3g\\AnredeModul\\3.17.0-SNAPSHOT\\AnredeModul-3.17.0-SNAPSHOT.jar"));
  }
  
  @Test
  public void extractGroupFromStringMatchingPattern_FindFirstGroup() {
    String searchString = SEARCH_STRING;
    
    String result = PatternMatcher.extractGroupFromStringMatchingPattern(REGEX_PATTERN, searchString, 1);
    
    assertThat(result, IsEqual.equalTo("file:\\"));
  }
  
  @Test
  public void extractGroupFromStringMatchingPattern_FindSecondGroup() {
    String searchString = SEARCH_STRING;
    
    String result = PatternMatcher.extractGroupFromStringMatchingPattern(REGEX_PATTERN, searchString, 2);
    
    assertThat(result, IsEqual.equalTo("B:\\MavenRepo\\de\\svi\\svis3g\\AnredeModul\\3.17.0-SNAPSHOT\\AnredeModul-3.17.0-SNAPSHOT.jar"));
  }
  
}
