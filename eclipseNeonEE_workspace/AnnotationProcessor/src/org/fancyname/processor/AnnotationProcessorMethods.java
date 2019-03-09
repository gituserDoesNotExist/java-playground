package org.fancyname.processor;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.fancyname.annotatoins.AnnotationWithBody;
import org.fancyname.annotatoins.CanRun;
import org.fancyname.annotatoins.CanRunOther;
import org.fancyname.classes.ClassWithAnnotations;

public class AnnotationProcessorMethods {

	public static void main(String[] args) throws Exception {

		ClassWithAnnotations classWithAnnotations = new ClassWithAnnotations();
		Method methods[] = classWithAnnotations.getClass().getDeclaredMethods();

		System.out.println(Arrays.asList(methods));

		for (Method method : methods) {
			if (method.getAnnotation(CanRun.class) != null) {
				System.out.println("got CanRun-Annotation");
				method.invoke(classWithAnnotations);
			}
			if (method.getAnnotation(CanRunOther.class) != null) {
				System.out.println("got CanRunOther-Annotation");
				method.invoke(classWithAnnotations, "parameter");
			}
			AnnotationWithBody annotation = method.getAnnotation(AnnotationWithBody.class);
			if (method.getAnnotation(AnnotationWithBody.class) != null) {
				System.out.println("got AnnotationWithBody-Annotation");
				method.invoke(classWithAnnotations, annotation.description());
			}
		}

	}

}
