package org.builder;

import java.util.List;

import org.builder.testshit.TestObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class ValueChangeExtractorTest {

	private TestObject testObject;
	private TestObject testObject2;

	@Before
	public void setUp() {
		testObject = new TestObject(23, "foo bar", "www.example.com");
		testObject2 = new TestObject(12, "bar foo", "www.example2.com");
	}

	@Test
	public void addField() {

		ValueAccessor<TestObject> accessor1 = new ValueAccessor<>("id", obj -> String.valueOf(obj.getId()));
		ValueAccessor<TestObject> accessor2 = new ValueAccessor<>("name", obj -> obj.getName());
		ValueAccessor<TestObject> accessor3 = new ValueAccessor<>("website", obj -> obj.getWebsite());

		ValueChangeExtractor<TestObject> extractor = new ValueChangeExtractor<>();
		extractor.addField(accessor1);
		extractor.addField(accessor2);
		extractor.addField(accessor3);

		List<DifferenceContainer> changes = extractor.extractChanges(testObject, testObject2);

		MatcherAssert.assertThat(changes, Matchers.hasSize(3));
		MatcherAssert.assertThat(changes.get(0).toString(),
				Matchers.equalTo("Attribute: id, oldValue: 23, newValue: 12"));
		MatcherAssert.assertThat(changes.get(1).toString(),
				Matchers.equalTo("Attribute: name, oldValue: foo bar, newValue: bar foo"));
		MatcherAssert.assertThat(changes.get(2).toString(),
				Matchers.equalTo("Attribute: website, oldValue: www.example.com, newValue: www.example2.com"));

	}

}
