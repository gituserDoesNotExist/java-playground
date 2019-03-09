package de.data.structure.queue;

import org.junit.Before;
import org.junit.Test;

public class CircularQueueImplTest {

	private CircularQueueImpl queue;

	@Before
	public void setUp() {
		queue = new CircularQueueImpl(4);
	}

	@Test
	public void playWithQueue() {
		queue.enqueue("first element");
		queue.enqueue("second element");
		queue.enqueue("third element");
		System.out.println(queue.size());
		System.out.println(queue.peek());
		queue.dequeue();
		System.out.println(queue.peek());
	}

}
