package de.data.structue.heap;

public class HeapImpl {

	public HeapImpl() {
	}

	public void heapSort(int[] array, int elementsInHeap) {
		int heapSize = elementsInHeap;
		buildMaxheap(array, elementsInHeap);
		for (int i = elementsInHeap; i >= 1; i--) {
			swap(array, 1, i);
			heapSize = heapSize - 1;
			maxHeapify(array, 1, heapSize);
		}
	}

	public void buildMaxheap(int[] array, int elementsInHeap) {
		int startIndex = array.length / 2;
		for (int index = startIndex; index >= 1; index--) {
			maxHeapify(array, index, elementsInHeap);
		}
	}

	public void maxHeapify(int[] arr, int nodeIndex, int elemensInHeap) {
		int left = 2 * nodeIndex;
		int right = 2 * nodeIndex + 1;
		int largest;

		if (left <= elemensInHeap && arr[left] > arr[nodeIndex]) {
			largest = left;
		} else {
			largest = nodeIndex;
		}
		if (right <= elemensInHeap && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != nodeIndex) {
			swap(arr, largest, nodeIndex);
			maxHeapify(arr, largest, elemensInHeap);
		}

	}

	private void swap(int[] arr, int index1, int index2) {
		int val1 = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = val1;
	}

}
