package de.data.structure.queue;

import org.junit.Before;
import org.junit.Test;

public class QueueImplTest {

	private QueueImpl queue;

	@Before
	public void setUp() {
		queue = new QueueImpl(4);
	}

	@Test
	public void playWithQueue() {
		queue.enqueue("first element");
		queue.enqueue("second element");
		queue.enqueue("third element");
		System.out.println(queue.peek());
		queue.dequeue();
		System.out.println(queue.peek());
	}

	@Test
	public void queueIsFull() {
		queue.enqueue("first element");
		queue.enqueue("second element");
		queue.enqueue("third element");
		queue.enqueue("fourth element");
		queue.dequeue();
		queue.enqueue("fifth element");
	}

}
