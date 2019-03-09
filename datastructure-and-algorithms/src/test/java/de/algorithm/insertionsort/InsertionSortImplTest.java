package de.algorithm.insertionsort;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class InsertionSortImplTest {

	private InsertionSortImpl insertionSort;

	@Before
	public void setUp() {
		insertionSort = new InsertionSortImpl();
	}

	@Test
	public void sortAscending() {
		int[] array = new int[] { 5, 4, 3, 2, 1 };

		insertionSort.sortAscending(array);

		Assertions.assertThat(array).containsExactly(new int[] { 1, 2, 3, 4, 5 });
	}

}
