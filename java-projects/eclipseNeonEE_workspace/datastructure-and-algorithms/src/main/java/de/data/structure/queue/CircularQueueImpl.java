package de.data.structure.queue;

public class CircularQueueImpl {

	private int head;
	private int tail;
	private int maxSize;
	private String[] list;

	public CircularQueueImpl(int maxSize) {
		this.maxSize = maxSize;
		this.tail = this.head = -1;
		list = new String[maxSize];
	}

	public void enqueue(String element) {
		if (isEmpty()) {
			this.tail = this.head = 0;
		}
		if (isFull()) {
			System.out.println("CircularQueue is full");
		} else {
			list[tail] = element;
			tail = (tail + 1) % maxSize;
		}
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("CircularQueue is empty");
		} else {
			String removedElement = list[head];
			head = (head + 1) % maxSize;
			System.out.println("removed element " + removedElement + " from CircularQueue");
		}
	}

	public String peek() {
		return list[head];
	}

	public int size() {
		if (head > tail) {
			return maxSize - (head - tail) + 1;
		}
		return tail - head;
	}

	private boolean isFull() {
		return size() == maxSize;
	}

	private boolean isEmpty() {
		return tail == head;
	}

	public int getHead() {
		return head;
	}

	public int getTail() {
		return tail;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public String[] getList() {
		return list;
	}

}
