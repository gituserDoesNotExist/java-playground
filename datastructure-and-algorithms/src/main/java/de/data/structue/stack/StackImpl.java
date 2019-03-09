package de.data.structue.stack;

import java.lang.reflect.Array;

public class StackImpl<T> {

	public static final int MAX_SIZE = 10;

	private int top;
	private T[] list;

	public StackImpl(Class<T[]> clazz, int length) {
		list = clazz.cast(Array.newInstance(clazz.getComponentType(), length));
		top = -1;
	}

	public void push(T element) {
		if (isFull()) {
			System.out.println("Stack is full");
		} else {
			list[++top] = element;
		}
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			T element = list[top--];
			System.out.println("Removed element: " + element);
		}
	}

	public T getElementOnTopOfStack() {
		return list[top];
	}

	private boolean isEmpty() {
		return top < 0;
	}

	private boolean isFull() {
		return top >= MAX_SIZE;
	}

	public int getTop() {
		return top;
	}

	public T[] getList() {
		return list;
	}

}
