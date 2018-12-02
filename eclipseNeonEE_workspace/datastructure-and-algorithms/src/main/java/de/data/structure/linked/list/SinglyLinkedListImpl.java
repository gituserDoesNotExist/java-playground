package de.data.structure.linked.list;

public class SinglyLinkedListImpl {

	private SinglyNodeImpl head;

	public SinglyLinkedListImpl() {
		this.head = null;
	}

	public void insertAtFront(SinglyNodeImpl node) {
		if (head == null) {
			head = node;
		} else {
			System.out.println("node: " + node);
			System.out.println("node.next: " + node.getNext());
			System.out.println("head: " + head);
			System.out.println("head.next: " + head.getNext());
			node.setNext(head);
			head = node;
			System.out.println("node: " + node);
			System.out.println("node.next: " + node.getNext());
			System.out.println("head: " + head);
			System.out.println("head.next: " + head.getNext());
		}
	}

	public void insertAtEnd(SinglyNodeImpl node) {
		if (head == null) {
			head = node;
		} else {
			SinglyNodeImpl lastElement = getLastElement();
			lastElement.setNext(node);
		}
	}

	private SinglyNodeImpl getLastElement() {
		SinglyNodeImpl currentElement = head;
		while (currentElement.getNext() != null) {
			currentElement = currentElement.getNext();
		}
		return currentElement;
	}

	public SinglyNodeImpl getHead() {
		return head;
	}
}
