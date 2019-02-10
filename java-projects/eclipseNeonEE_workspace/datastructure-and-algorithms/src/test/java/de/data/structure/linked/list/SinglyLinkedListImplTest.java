package de.data.structure.linked.list;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListImplTest {

	private SinglyLinkedListImpl linkedList;

	@Before
	public void setUp() {
		linkedList = new SinglyLinkedListImpl();
	}

	@Test
	public void insertAtFront() {
		linkedList.insertAtEnd(new SinglyNodeImpl("first element inserted at end"));
		linkedList.insertAtFront(new SinglyNodeImpl("first element inserted at front"));
		linkedList.insertAtFront(new SinglyNodeImpl("second element inserted at front"));

		System.out.println(linkedList.getHead().getElement());
		System.out.println(linkedList.getHead().getNext().getElement());
	}

	@Test
	public void insertAtEnd() {
		linkedList.insertAtEnd(new SinglyNodeImpl("first element"));
		linkedList.insertAtEnd(new SinglyNodeImpl("second element"));
		linkedList.insertAtEnd(new SinglyNodeImpl("third element"));

		System.out.println(linkedList.getHead().getElement());
		System.out.println(linkedList.getHead().getNext().getElement());
	}

}
