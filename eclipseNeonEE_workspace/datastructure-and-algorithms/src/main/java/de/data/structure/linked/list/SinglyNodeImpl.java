package de.data.structure.linked.list;

public class SinglyNodeImpl {

	private String element;
	private SinglyNodeImpl next;

	public SinglyNodeImpl(String element) {
		this.element = element;
		this.next = null;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public void setNext(SinglyNodeImpl next) {
		this.next = next;
	}

	public String getElement() {
		return element;
	}

	public SinglyNodeImpl getNext() {
		return next;
	}

	@Override
	public String toString() {
		return super.toString() + " ; " + this.element;
	}

}
