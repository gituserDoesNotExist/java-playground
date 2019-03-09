package myPackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springBeans.xml");
		Shape shape = (Shape) context.getBean("triangle");
		shape.draw();
	}
}
