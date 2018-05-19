package com.desaco.Algorithm.DataStructure.SortingStructure.MergeSort;

/**
 * 归并排序是一个分治算法(Divide and
 * Conquer)的一个典型实例，把一个数组分为两个大小相近(最多差一个)的子数组，分别把子数组都排好序之后通过归并
 * (Merge)手法合成一个大的排好序的数组
 * ，归并的过程依然用扑克来解释，想象一下桌子上有两堆排好序(从小到大)的牌，每一次从两堆里面各抽取一张，比较一下两张的大小
 * ，如果两张一样大，都取出放到目标数组
 * ，否则取出较小的放到目标数组，另外一个放回原堆里面。归并排序需要额外的空间来存储临时数据，不过它的最坏运行时间都是O(nlogn)。
 * 
 * 归并排序为分治法，分体现在把一个数组分为基本等长的两个子数组，重复这个过程，直到两个子数组都只有一个元素，归并的过程是算法的核心，前面已经提到过。
 * 
 * 
 * @author desaco
 * 
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

		System.out.println("Before sort:");
		ArrayUtils.printArray(array);

		mergeSort(array);

		System.out.println("After sort:");
		ArrayUtils.printArray(array);
	}

	public static void mergeSort(int[] array) {
		sortArray(array, 0, array.length - 1);
	}

	private static void sortArray(int[] array, int start, int end) {
		// 单个元素不需要排序,直接返回
		if (start == end) {
			return;
		}

		int sortSize = end - start + 1;
		int seperate;
		if (sortSize % 2 == 0) {
			seperate = start + sortSize / 2 - 1;
		} else {
			seperate = start + sortSize / 2;
		}

		sortArray(array, start, seperate);
		sortArray(array, seperate + 1, end);

		mergeArray(array, start, seperate, end);
	}

	private static void mergeArray(int[] array, int start, int seperate, int end) {
		int totalSize = end - start + 1;
		int size1 = seperate - start + 1;
		int size2 = end - seperate;

		int[] array1 = new int[size1];
		int[] array2 = new int[size2];

		for (int i = 0; i < size1; i++) {
			array1[i] = array[start + i];
		}

		for (int i = 0; i < size2; i++) {
			array2[i] = array[seperate + 1 + i];
		}

		int mergeCount = 0;
		int index1 = 0;
		int index2 = 0;

		while (mergeCount < totalSize) {
			// 先检查有没有其中的一个数组已经处理完
			if (index1 == size1) {
				for (int i = index2; i < size2; i++) {
					array[start + mergeCount] = array2[i];
					mergeCount++;
					index2++;
				}
			} else if (index2 == size2) {
				for (int i = index1; i < size1; i++) {
					array[start + mergeCount] = array1[i];
					mergeCount++;
					index1++;
				}
			} else {
				int value1 = array1[index1];
				int value2 = array2[index2];

				if (value1 == value2) {
					array[start + mergeCount] = value1;
					array[start + mergeCount + 1] = value1;
					mergeCount += 2;
					index1++;
					index2++;
				} else if (value1 < value2) {
					array[start + mergeCount] = value1;
					mergeCount++;
					index1++;
				} else if (value1 > value2) {
					array[start + mergeCount] = value2;
					mergeCount++;
					index2++;
				}
			}
		}
	}
}
