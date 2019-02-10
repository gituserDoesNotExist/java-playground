package org.builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

import org.builder.testshit.TestObject;
import org.junit.Before;
import org.junit.Test;

public class ValueAccessorTest {

	private Function<TestObject, String> anyFunction;
	private ValueAccessor<TestObject> accessor;

	@Before
	public void setUp() {
		anyFunction = (TestObject obj) -> obj.getName();
		accessor = new ValueAccessor<>("name", anyFunction);
	}

	@Test
	public void apply() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		TestObject obj = new TestObject(1, "john doe", "www.example.com");

		Method method = ValueAccessor.class.getMethod("apply", Object.class);

		method.invoke(accessor, obj);

		System.out.println(method);
	}

}
