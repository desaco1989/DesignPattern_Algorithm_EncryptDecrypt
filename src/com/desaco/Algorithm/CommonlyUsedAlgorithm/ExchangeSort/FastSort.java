package com.desaco.Algorithm.CommonlyUsedAlgorithm.ExchangeSort;

/**
 * 快速排序
 * 
 
 * @author desaco
 *         对于基准位置的选取一般有三种方法：固定切分，随机切分和三取样切分。固定切分的效率并不是太好，随机切分是常用的一种切分，效率比较高，
 *         最坏情况下时间复杂度有可能为O(N2).对于三数取中选择基准点是最理想的一种。 基于分治的思想，是冒泡排序的改进型。
 * 
 *         https://www.cnblogs.com/hjy9420/p/5032309.html
 *
 */
public class FastSort {
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] a = { 12, 20, 5, 16, 15, 1, 30, 45, 23, 9 };
		int start = 0;
		int end = a.length - 1;
		sort(a, start, end);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

	public static void sort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];

		while (end > start) {
			// 从后往前比较
			while (end > start && a[end] >= key) // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
				end--;
			if (a[end] <= key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			// 从前往后比较
			while (end > start && a[start] <= key)// 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
				start++;
			if (a[start] >= key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
		}
		// 递归
		if (start > low)
			sort(a, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
		if (end < high)
			sort(a, end + 1, high);// 右边序列。从关键值索引+1到最后一个
	}

	// --------------------------------------------------------------------
	// --------------------------------------------------------------------
	// --------------------------------------------------------------------
	// 第二种方法
	public static int partition(int[] array, int lo, int hi) {
		// 固定的切分方式
		int key = array[lo];
		while (lo < hi) {
			while (array[hi] >= key && hi > lo) {// 从后半部分向前扫描
				hi--;
			}
			array[lo] = array[hi];
			while (array[lo] <= key && hi > lo) {// 从前半部分向后扫描
				lo++;
			}
			array[hi] = array[lo];
		}
		array[hi] = key;
		return hi;
	}

	public static void sort2(int[] array, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int index = partition(array, lo, hi);
		sort2(array, lo, index - 1);
		sort2(array, index + 1, hi);
	}

}
