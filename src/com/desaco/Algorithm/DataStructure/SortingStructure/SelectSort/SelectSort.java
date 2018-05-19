package com.desaco.Algorithm.DataStructure.SortingStructure.SelectSort;

/**
 * http://zengzhaoshuai.iteye.com/blog/1171921
 * 
 * 直接选择排序(Straight Select Sorting)
 * 也是一种简单的排序方法，它的基本思想是：第一次从R[0]~R[n-1]中选取最小值，与R[0
 * ]交换，第二次从R{1}~R[n-1]中选取最小值，与R[1]交换，....，
 * 　　第i次从R[i-1]~R[n-1]中选取最小值，与R[i-1]交换，...
 * ..，第n-1次从R[n-2]~R[n-1]中选取最小值，与R[n-2]交换,总共通过n-1次,得到一个按排序码从小到大排列的有序序列.
 * 
 * @author desaco
 * 
 */
public class SelectSort {
	public static void selectSort(DataWrap[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;
		// 依次进行n－1趟比较, 第i趟比较将第i大的值选出放在i位置上。
		for (int i = 0; i < arrayLength - 1; i++) {
			// 第i个数据只需和它后面的数据比较
			for (int j = i + 1; j < arrayLength; j++) {
				// 如果第i位置的数据 > j位置的数据, 交换它们
				if (data[i].compareTo(data[j]) > 0) {
					DataWrap tmp = data[i];
					data[i] = data[j];
					data[j] = tmp;
				}
			}
			System.out.println(java.util.Arrays.toString(data));
		}
	}

	public static void main(String[] args) {
		DataWrap[] data = { new DataWrap(21, ""), new DataWrap(30, ""),
				new DataWrap(49, ""), new DataWrap(30, "*"),
				new DataWrap(16, ""), new DataWrap(9, "") };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		selectSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
