package de.data.structue.heap;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class HeapImplTest {

	private HeapImpl heap;

	@Before
	public void setUp() {
		heap = new HeapImpl();
	}

	@Test
	public void maxHeapify_StartingAtRoot() {
		int[] array = new int[] { 0, 4, 7, 8, 3, 2, 6, 5 };

		heap.maxHeapify(array, 1, array.length);

		Assertions.assertThat(Arrays.asList(array)).containsExactly(new int[] { 0, 8, 7, 6, 3, 2, 4, 5 });
	}

	@Test
	public void maxHeapify_StartingAtLeftChildOfRoot() {
		int[] array = new int[] { 0, 4, 7, 1, 3, 2, 6, 5 };

		heap.maxHeapify(array, 3, array.length);

		Assertions.assertThat(Arrays.asList(array)).containsExactly(new int[] { 0, 4, 7, 6, 3, 2, 1, 5 });
	}

	@Test
	public void maxHeapify_Experiment() {
		int[] array = new int[] { 0, 4, 5, 8, 3, 2, 6, 5 };

		heap.maxHeapify(array, 1, array.length);

		Assertions.assertThat(Arrays.asList(array)).containsExactly(new int[] { 0, 8, 5, 6, 3, 2, 4, 5 });
	}

	@Test
	public void maxHeapify_Experiment2() {
		int[] array = new int[] { 0, 4, 7, 8, 3, 2, 12, 5 };

		heap.maxHeapify(array, 1, array.length);

		Assertions.assertThat(Arrays.asList(array)).containsExactly(new int[] { 0, 8, 7, 12, 3, 2, 4, 5 });
	}

	@Test
	public void buildMaxheap() {
		int[] array = new int[] { 0, 1, 4, 3, 7, 8, 9, 10 };

		heap.buildMaxheap(array, array.length - 1);

		Assertions.assertThat(Arrays.asList(array)).containsExactly(new int[] { 0, 10, 8, 9, 7, 4, 1, 3 });
	}

	@Test
	public void heapSort() {
		int[] array = new int[] { 0, 4, 3, 7, 1, 8, 5 };

		heap.heapSort(array, array.length - 1);

		Assertions.assertThat(Arrays.asList(array)).containsExactly(new int[] { 0, 1, 3, 4, 5, 7, 8 });
	}

}
