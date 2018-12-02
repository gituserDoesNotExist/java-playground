package de.algorithm.insertionsort;

public class InsertionSortImpl {

	public InsertionSortImpl() {
	}

	public void sortAscending(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int elementToInsert = array[i];
			int j = i;
			while (j > 0 && elementToInsert < array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = elementToInsert;
		}
	}

}
