package de.any.crawl;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

public class RequiredBeanContainerTest {

	private static final String BEAN_ID = "bean";
	private static final String OTHER_BEAN_ID = "other";
	private RequiredBeanContainer container = new RequiredBeanContainer();

	@Test
	public void add() {
		TestRequiredBean bean = new TestRequiredBean(BEAN_ID);
		TestRequiredBean other = new TestRequiredBean(OTHER_BEAN_ID);

		container.addIfNotPresent(bean);
		container.addIfNotPresent(other);
		container.addIfNotPresent(bean);

		assertThat(container.getRequiredBeans().stream().map(RequiredBean::getBeanId).collect(Collectors.toList()),
				IsIterableContainingInAnyOrder.containsInAnyOrder(BEAN_ID, OTHER_BEAN_ID));
	}

	@Test
	public void addAll() {
		TestRequiredBean bean = new TestRequiredBean(BEAN_ID);
		TestRequiredBean other = new TestRequiredBean(OTHER_BEAN_ID);

		container.addAllIfNotPresent(Arrays.asList(bean, other, bean));

		assertThat(container.getRequiredBeans().stream().map(RequiredBean::getBeanId).collect(Collectors.toList()),
				IsIterableContainingInAnyOrder.containsInAnyOrder(BEAN_ID, OTHER_BEAN_ID));
	}

}
