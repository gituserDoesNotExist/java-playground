package de.data.structue.stack;

import org.junit.Before;
import org.junit.Test;

public class StackImplTest {

	private StackImpl<String> stack;

	@Before
	public void setUp() {
		stack = new StackImpl<String>(String[].class, 10);
	}

	@Test
	public void playWithStack() {
		stack.push("first element");
		System.out.println(stack.getTop());
		System.out.println(stack.getElementOnTopOfStack());
		stack.push("second element");
		System.out.println(stack.getTop());
		System.out.println(stack.getElementOnTopOfStack());
		stack.push("third element");
		System.out.println(stack.getTop());
		System.out.println(stack.getElementOnTopOfStack());
		stack.pop();
		System.out.println(stack.getTop());
		System.out.println(stack.getElementOnTopOfStack());
		stack.pop();
		System.out.println(stack.getTop());
		System.out.println(stack.getElementOnTopOfStack());
	}

	@Test
	public void componentType() {
		Class<String[]> clazz = String[].class;
		System.out.println(clazz.getComponentType());
		Class<String> clazz2 = String.class;
		System.out.println(clazz2.getComponentType());
	}

	@Test
	public void testName() {
		int i = 0;
		int j = 0;
		System.out.println(i++);
		System.out.println(i);
		System.out.println(++j);
		System.out.println(j);
	}

}
