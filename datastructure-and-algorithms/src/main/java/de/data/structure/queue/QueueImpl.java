package de.data.structure.queue;

public class QueueImpl {

	private int tail, head;
	private String[] list;
	private int maxSize;

	public QueueImpl(int maxSize) {
		this.tail = this.head = -1;
		list = new String[maxSize];
		this.maxSize = maxSize;
	}

	public void enqueue(String element) {
		if (isEmpty()) {
			head = 0;
		}
		if (isFull()) {
			System.out.println("Queue is full");
		} else {
			list[++tail] = element;
		}
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			String element = list[head++];
			System.out.println("Removing element " + element + " from Queue");
		}
	}

	public String peek() {
		return list[head];
	}

	private boolean isFull() {
		return tail == maxSize - 1;
	}

	private boolean isEmpty() {
		return head < 0;
	}

	public int getTail() {
		return tail;
	}

	public int getHead() {
		return head;
	}

	public String[] getList() {
		return list;
	}

}
