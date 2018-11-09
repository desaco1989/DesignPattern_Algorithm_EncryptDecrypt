package com.desaco.Algorithm.CommonlyUsedAlgorithm.ExchangeSort;

import java.util.Arrays;

/**
 * 时间复杂度：n-n的平方
 * 
 * 交换排序：交换数据元素的位置
 * 
 * 冒泡排序
 * 
 * 相邻的两个元素相比较，可能需要交换位置；最大元素放在数组的最后面
 * 
 * @author desaco
 *
 */
public class BubbleSort {
	public static void BubbleSort(int[] arr) {
		int temp;// 定义一个临时变量
		for (int i = 0; i < arr.length - 1; i++) {// 冒泡趟数
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 6, 2, 2, 5 };
		BubbleSort.BubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
