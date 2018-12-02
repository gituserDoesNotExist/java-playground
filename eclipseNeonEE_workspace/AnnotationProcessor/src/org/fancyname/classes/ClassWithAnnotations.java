package org.fancyname.classes;

import org.fancyname.annotatoins.AnnotationWithBody;
import org.fancyname.annotatoins.CanRun;
import org.fancyname.annotatoins.CanRunOther;

public class ClassWithAnnotations {

	private String field = "field value";

	@CanRun
	public void method1() {
		System.out.println("I am method 1");
	}

	@CanRunOther
	public void method2(String param) {
		System.out.println("I am a method with paramter " + param);
	}

	@CanRun
	public void method3() {
		System.out.println("I am method 3");
	}

	@AnnotationWithBody(description = "Hello World!")
	public void method4(String param) {
		System.out.println("annotation with body says: " + param);
	}

}
