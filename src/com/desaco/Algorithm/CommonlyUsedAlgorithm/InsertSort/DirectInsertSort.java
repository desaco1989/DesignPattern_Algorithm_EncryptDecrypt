package com.desaco.Algorithm.CommonlyUsedAlgorithm.InsertSort;

/**
 * 直接插入排序
 * 
 * 3.1：当n <= 50时，适合适用直接插入排序和简单选择排序，如果元素包含的内容过大，就不适合直接插入排序，因为直接插入排序需要移动元素的次数比较多.
 * 3.2：当数组基本有序的情况下适合使用直接插入排序和冒泡排序，它们在基本有序的情况下排序的时间复杂度接近O(n).
 * 
 * 假设待排序的数据是数组A[1….n]。初始时，A[1]自成1个有序区，无序区为A[2….n]。在排序的过程中， 依次将A[i]
 * (i=2,3,….,n)从后往前插入到前面已排好序的子数组A[1,…,i-1]中的适当位置，当所有的A[i]
 * 插入完毕，数组A中就包含了已排好序的输出序列。
 *
 * 
 * @author desaco
 *
 */
public class DirectInsertSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 11, 10, 55, 78, 100, 111, 45, 56, 79, 90, 345, 1000 };// 创建一个数组a
		System.out.println("排序之前：");
		DirectInsertSort.output(a);
		System.out.println();
		DirectInsertSort.Sort(a);
		System.out.println("排序之后：");
		DirectInsertSort.output(a);
	}

	// 插入排序
	public static void Sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int tempdata = arr[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > tempdata) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = tempdata;
		}
	}

	// 输出打印
	public static void output(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

}
