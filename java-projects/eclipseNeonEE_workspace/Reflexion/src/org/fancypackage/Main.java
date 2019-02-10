package org.fancypackage;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = Person.class.getMethod("print", Object.class);

		method.invoke(new Person(), "this is a string");
		method.invoke(new Person(), 273);
		method.invoke(new Person(), new Object());

		String[] property = System.getProperty("java.class.path").split(File.pathSeparator);
		for (String string : property) {
			System.out.println(string);
		}
	}

}
