package com.desaco.Algorithm.DataStructure.SortingStructure.SelectSort;

/**
 * 选择排序的基本思想：第i趟简单选择排序是指通过n-i次关键字的比较，从n-i+1个记录中选出关键字最小的记录，并和第i个记录进行交换。先临时记录其位置，
 * 只有在一趟 循环完以后确定了最小的数据，才会发生交换。
 * 
 * @author desaco
 * 
 */
public class ChoiceSort {
	public static void _choiceSort(Integer[] a) {
		if (a == null || a.length <= 0) {
			return;
		}
		for (int i = 0; i < a.length; i++) {
			int min = i; /* 将当前下标定义为最小值下标 */

			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) { /* 如果有小于当前最小值的关键字 */
					min = j; /* 将此关键字的下标赋值给min */
				}
			}
			if (i != min) {/* 若min不等于i，说明找到最小值，交换 */
				int tmp = a[min];
				a[min] = a[i];
				a[i] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = { 49, 38, 65, 97, 76, 13, 27, 14, 10 };
		// 快速排序
		/*
		 * QuicSort qs=new QuicSort(); qs.quick(list);
		 */
		// 冒泡排序
		/*
		 * BubbleSort bs=new BubbleSort(); bs.bubble(list);
		 */
		// 选择排序
		ChoiceSort._choiceSort(list);

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}
