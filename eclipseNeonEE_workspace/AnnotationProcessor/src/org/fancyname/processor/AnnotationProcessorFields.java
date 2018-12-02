package org.fancyname.processor;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.fancyname.classes.ClassWithAnnotations;

public class AnnotationProcessorFields {

	public static void main(String[] args) throws Exception {
		Class<ClassWithAnnotations> aClass = ClassWithAnnotations.class;
		Field[] declaredFields = aClass.getDeclaredFields();

		for (Field field : declaredFields) { // array for fields names

			System.out.println("Field modifier: " + Modifier.toString(field.getModifiers()));
			System.out.println("Field type: " + field.getType().getName());
			System.out.println("Field name: " + field.getName());
			field.setAccessible(true);// nur notwendig wenn Member als private
										// deklariert ist
			System.out.println("Field value: " + field.get(new ClassWithAnnotations()));
			System.out.println("Fields: " + field.toString());
		}
	}

}
