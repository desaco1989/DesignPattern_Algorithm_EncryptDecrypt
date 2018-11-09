package com.desaco.Algorithm.CommonlyUsedAlgorithm.MergeSort;

import java.util.Arrays;

/**
 * 二路归并或多路归并算法
 * 
 * 快速排序：是先把数组粗略的排序成两个子数组，然后递归再粗略分两个子数组，直到子数组里面只有一个元素， 那么就自然排好序了，可以总结为先排序再递归；
 * 
 * 归并排序：先什么都不管，把数组分为两个子数组，一直递归把数组划分为两个子数组，直到数组里只有一个元素，这时候才开始排序，
 * 让两个数组间排好序，依次按照递归的返回来把两个数组进行排好序，到最后就可以把整个数组排好序；
 *
 * 
 * 
 * @author desaco
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[] { 11, 9, 7, 5, 3, 1, 12, 10, 8, 6, 4, 2 };

		int[] tmp = new int[a.length];
		mergesort(a, 0, a.length - 1, tmp);
	}

	//归并排序
	private static void mergearray(int[] array, int start, int middle, int end, int[] tmp) {

		int first = start;
		int second = middle + 1;
		int index = start;

		while ((first <= middle) && (second <= end)) {
			if (array[first] >= array[second])
				tmp[index++] = array[second++];
			else
				tmp[index++] = array[first++];
		}
		while (first <= middle)
			tmp[index++] = array[first++];
		while (second <= end)
			tmp[index++] = array[second++];

		for (first = start; first <= end; first++)
			array[first] = tmp[first];

		System.out.println("merge is " + Arrays.toString(array));

	}

	public static void mergesort(int[] array, int start, int end, int[] tmp) {

		if (start >= end)
			return;
		int middle = ((end + start) >> 1);
		mergesort(array, start, middle, tmp);// 递归划分左边的数组
		mergesort(array, middle + 1, end, tmp);// 递归划分右边的数组
		mergearray(array, start, middle, end, tmp);// 对有序的两个数组进行合并成一个有序的数组
	}
}
