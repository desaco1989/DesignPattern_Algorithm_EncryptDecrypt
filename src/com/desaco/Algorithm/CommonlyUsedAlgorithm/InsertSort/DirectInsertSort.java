package com.desaco.Algorithm.CommonlyUsedAlgorithm.InsertSort;

/**
 * 插入排序：后面元素插入前面元素中
 * 
 * 直接插入排序
 * 
 * 时间复杂度：n- n的平方
 * 空间复杂度：1
 * 
 * 3.1：当n <= 50时，适合适用直接插入排序和简单选择排序，如果元素包含的内容过大，就不适合直接插入排序，因为直接插入排序需要移动元素的次数比较多.
 * 3.2：当数组基本有序的情况下适合使用直接插入排序和冒泡排序，它们在基本有序的情况下排序的时间复杂度接近O(n).
 * 
 * 假设待排序的数据是数组A[1….n]。初始时，A[1]自成1个有序区，无序区为A[2….n]。在排序的过程中， 依次将A[i]
 * (i=2,3,….,n)从后往前插入到前面已排好序的子数组A[1,…,i-1]中的适当位置，当所有的A[i]
 * 插入完毕，数组A中就包含了已排好序的输出序列。
 * @author desaco
 *
 */
public class DirectInsertSort {
	// 插入排序
		public static void Sort(int[] arr) {
			for (int i = 1; i < arr.length; i++) {// 3 1
				System.out.println(" ------------------");
				int tempdata = arr[i];// 临时数据 1 , i=1, tempdata=1
				int j;
				for (j = i - 1; j >= 0; j--) {// j=0
					System.out.println(" +++++++++++++++++++++++++");

					if (arr[j] > tempdata) {
						arr[j + 1] = arr[j];// arr[j + 1] =3 ,a[1]=3
						System.out.println(" ????????????");
						// System.out.println(" test1：" + arr[j + 1]);
						// System.out.println(" test2：" + arr[j]);
					} else {
						System.out.println(" %%%%%%%%%%%%%%%%%%%%");
						break;
					}
					// 循环执行一遍后 j=-1
				}
				arr[j + 1] = tempdata;
				System.out.println("bbb arr[j +1]=" + arr[j + 1]);
				if (j >= 0) {
					System.out.println("bbb arr[j ]=" + arr[j]);
				}
				// System.out.println("bbb test3：j=" + j);
				// System.out.println("bbb test4：j +1=" + (j + 1));
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] a = { 11, 10, 55, 78, 100, 111, 45, 56, 79, 90, 345, 1000 };//
		// 创建一个数组a
		// int[] a = { 3,1 };// 创建一个数组a
		int[] a = { 2, 3, 1 };// 创建一个数组a
		System.out.println("排序之前：");
		DirectInsertSort.output(a);
		System.out.println();
		DirectInsertSort.Sort(a);
		System.out.println("排序之后：");
		DirectInsertSort.output(a);
	}

	

	// 输出打印
	public static void output(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	// 直接插入排序
	public static void Sort2(int[] arr) {
		for (int i = 1; i < arr.length; i++) {// 3 1
			int tempdata = arr[i];// 临时数据 1 , i=1, tempdata=1
			int j;
			for (j = i - 1; j >= 0; j--) {// j=0
				if (arr[j] > tempdata) {
					arr[j + 1] = arr[j];// arr[j + 1] =3 ,a[1]=3
				} else {
					break;
				}
				// 循环执行一遍后 j=-1
			}
			arr[j + 1] = tempdata;
		}
	}

}
