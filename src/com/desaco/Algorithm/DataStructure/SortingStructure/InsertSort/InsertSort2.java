package com.desaco.Algorithm.DataStructure.SortingStructure.InsertSort;

/**
 * http://www.linuxidc.com/Linux/2014-12/110429.htm
 * 
 * 直接插入排序有二种实现方式，带哨兵与不带哨兵。
 * 
 * 带哨兵的插入排序中的哨兵元素有两个作用： 1、暂时存放待插入的元素，相当于临时存储元素。
 * 2、可以防止数组下标越界，当待插入的元素小于已排序的子数组中的最小元素时，j=-1,越界，而采用哨兵，arr[0]<arr[j],当j=0时，就结束循环，
 * 不会出现越界（for循环只有一次判断，提高了效率）。
 * 
 * @author desaco
 *
 */
public class InsertSort2 {
	/**
	 * 带哨所
	 * 
	 * @param sortList
	 */
	public static void insertSort1(Integer[] sortList) {
		int len = sortList.length;
		for (int i = 2; i < len; i++) {
			if (sortList[i] < sortList[i - 1]) {
				int j = i - 1;
				sortList[0] = sortList[i];// 设置哨所
				while (sortList[0] < sortList[j]) {
					sortList[j + 1] = sortList[j];
					j--;
				}
				sortList[j + 1] = sortList[0];
			}
		}
	}

	/**
	 * 不带哨所
	 * 
	 * @param sortList
	 */
	public static void insertSort2(Integer[] sortList) {
		int len = sortList.length;
		for (int i = 1; i < len; i++) {
			if (sortList[i] < sortList[i - 1]) {
				int j = i - 1;
				int temp = sortList[i];
				while (j >= 0 && temp < sortList[j]) {
					sortList[j + 1] = sortList[j];
					j--;
				}
				sortList[j + 1] = temp;
			}
		}
	}
}
