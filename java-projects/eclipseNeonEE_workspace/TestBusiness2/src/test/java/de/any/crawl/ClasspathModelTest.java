package de.any.crawl;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
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
public class ClasspathModelTest {

	private static final Class<TestInterface> IMPLEMENTED_INTERFACE = TestInterface.class;
	private static final Class<ClassImplementingTestInterface> IMPLEMENTING_CLASS = ClassImplementingTestInterface.class;

	private ClasspathModel model;

	@Before
	public void setUp() {
		model = new ClasspathModel(Arrays.asList(IMPLEMENTING_CLASS, IMPLEMENTED_INTERFACE, ClasspathModelTest.class));
	}

	@Test
	public void findClassImplementingInterface_InterfaceImplementedByOneClass() {
		Class<?> result = model.findClassImplementingInterface(IMPLEMENTED_INTERFACE).get();

		assertThat(result, equalTo(IMPLEMENTING_CLASS));
	}

	@Test
	public void findClassImplementingInterface_InterfaceImplementedByTwoClasses_ReturnsOnlineImplementation() {
		model = new ClasspathModel(Arrays.asList(TestInterfaceWithTwoImplementations.class, ClassImplementingTestInterfaceWithTwoImplementations.class,
				ClasspathModelTest.class, OnlineClassImplementingTestInterfaceWithTwoImplementations.class));

		Class<?> result = model.findClassImplementingInterface(TestInterfaceWithTwoImplementations.class).get();

		assertThat(result, equalTo(OnlineClassImplementingTestInterfaceWithTwoImplementations.class));
	}

	@Test
	public void findImplementationClassForType_ReturnsImplementingClassWhenGivenInterface() {
		Class<?> result = model.findImplementationClassForType(IMPLEMENTED_INTERFACE).get();

		assertThat(result, equalTo(IMPLEMENTING_CLASS));
	}

	@Test
	public void findImplementationClassForType_ReturnsImplementingClassWhenGivenImplementingClass() {
		Class<?> result = model.findImplementationClassForType(IMPLEMENTED_INTERFACE).get();

		assertThat(result, equalTo(IMPLEMENTING_CLASS));
	}

	class ClassImplementingTestInterface implements TestInterface {

	}

	class ClassImplementingTestInterfaceWithTwoImplementations implements TestInterfaceWithTwoImplementations {

	}

	class OnlineClassImplementingTestInterfaceWithTwoImplementations implements TestInterfaceWithTwoImplementations {

	}

}
