package com.desaco.Algorithm.DataStructure.SortingStructure.SelectSort;

/**
 * 堆排序的大概步骤如下:
 * 
 * 1.构建最大堆。 2.选择顶，并与第0位置元素交换
 * 3.由于步骤2的的交换可能破环了最大堆的性质，第0不再是最大元素，需要调用maxHeap调整堆(沉降法)，如果需要重复步骤2
 * 
 * 堆排序中最重要的算法就是maxHeap，该函数假设一个元素的两个子节点都满足最大堆的性质(左右子树都是最大堆)，只有跟元素可能违反最大堆性质，
 * 那么把该元素以及左右子节点的最大元素找出来
 * ，如果该元素已经最大，那么整棵树都是最大堆，程序退出，否则交换跟元素与最大元素的位置，继续调用maxHeap原最大元素所在的子树
 * 。该算法是分治法的典型应用。
 * 
 * 
 * @author desaco
 * 
 */
public class HeapSort2 {
	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

		System.out.println("Before heap:");
		ArrayUtils.printArray(array);

		heapSort(array);

		System.out.println("After heap sort:");
		ArrayUtils.printArray(array);
	}

	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		buildMaxHeap(array);

		for (int i = array.length - 1; i >= 1; i--) {
			ArrayUtils.exchangeElements(array, 0, i);

			maxHeap(array, i, 0);
		}
	}

	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	private static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (index != largest) {
			ArrayUtils.exchangeElements(array, index, largest);

			maxHeap(array, heapSize, largest);
		}
	}
}
