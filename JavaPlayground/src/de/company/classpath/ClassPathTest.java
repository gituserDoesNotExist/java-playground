package de.company.classpath;

import java.io.File;

public class ClassPathTest {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(System.getProperty("java.class.path"));
		String[] property = System.getProperty("java.class.path").split(File.pathSeparator);
		for (String string : property) {
			System.out.println(string);
		}
	}

}
