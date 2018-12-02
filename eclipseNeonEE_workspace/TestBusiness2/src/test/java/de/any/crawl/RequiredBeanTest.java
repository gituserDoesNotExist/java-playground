package de.any.crawl;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RequiredBeanTest {

	private static final TestRequiredBean BEAN = new TestRequiredBean("bean");
	private static final TestRequiredBean OTHER = new TestRequiredBean("other");

	@Test
	public void testEquals_ReturnsTrue() {
		TestRequiredBean bean = BEAN;
		TestRequiredBean beanWithSameId = BEAN;

		// Reflexivität
		assertTrue(bean.equals(bean));
		// Symmetrie
		assertTrue(bean.equals(beanWithSameId));
		assertTrue(beanWithSameId.equals(bean));
		// Transitivität
		TestRequiredBean thirdBeanWithSameId = BEAN;
		assertTrue(bean.equals(beanWithSameId));
		assertTrue(beanWithSameId.equals(thirdBeanWithSameId));
		assertTrue(bean.equals(thirdBeanWithSameId));
		// Konsistenz
		assertTrue(bean.equals(beanWithSameId));
		assertTrue(bean.equals(beanWithSameId));
		assertTrue(new TestRequiredBean(null).equals(new TestRequiredBean(null)));
	}

	@Test
	public void testEquals_ReturnsFalse() {
		TestRequiredBean bean = BEAN;
		TestRequiredBean otherBean = OTHER;

		assertFalse(bean.equals(null));
		assertFalse(bean.equals(otherBean));
	}

	@Test
	public void testHashCode() {
		TestRequiredBean bean = BEAN;
		TestRequiredBean beanWithSameId = BEAN;

		assertTrue(bean.equals(beanWithSameId));
		assertTrue(bean.hashCode() == beanWithSameId.hashCode());
	}

	@Test
	public void testToString() {
		assertEquals(BEAN.toString(), "de.any.crawl.TestRequiredBean[id=bean]");
	}
}
