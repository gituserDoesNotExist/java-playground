package myHibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;
import org.slf4j.LoggerFactory;

public class HibernateTest {
	
	public static void main(String[] args) {
		String[]  test = new String[] {"test1","test2","test3"};
		List<String> myList = Arrays.asList(test);
		System.out.println(Arrays.toString(test));
		System.out.println(myList);
		
		System.out.println("change return list");
		System.out.println("change return list");
		myList.set(2, "new");
		System.out.println(Arrays.toString(test));
		System.out.println(myList);
		System.out.println("change original list");
		test[0] = "change";
		System.out.println(Arrays.toString(test));
		System.out.println(myList);
		

		

	}
}
