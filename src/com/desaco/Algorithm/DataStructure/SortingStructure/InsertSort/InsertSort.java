package com.desaco.Algorithm.DataStructure.SortingStructure.InsertSort;

/**
 * http://www.oschina.net/code/snippet_131893_15742
 * 
 * 直接插入排序(Insertion Sort)的基本思想是：每次将一个待排序的记录，按其关
 * 键字大小插入到前面已经排好序的子序列中的适当位置，直到全部记录插入完成 为止。
 * 
 * http://www.oschina.net/code/snippet_131893_15742
 * 
 * @author desaco
 *
 */
public class InsertSort {
	/*
	 * 直接插入排序(Insertion Sort)的基本思想是：每次将一个待排序的记录，按其关
	 * 键字大小插入到前面已经排好序的子序列中的适当位置，直到全部记录插入完成 为止。
	 * 
	 * 设数组为a[0…n-1]。 
	 * 1. 初始时，a[0]自成1个有序区，无序区为a[1..n-1]。令i=1 
	 * 2. 将a[i]并入当前的有序区a[0…i-1]中形成a[0…i]的有序区间。
	 * 3. i++并重复第二步直到i==n-1。排序完成。
	 */
	public static void insertSort1(int[] a, int n) {
		int i, j, k;
		for (i = 1; i < n; i++) {
			// 为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
			for (j = i - 1; j >= 0; j--) {
				if (a[j] < a[i]) {
					break;
				}
			}

			// 将比a[i]大的数据向后移
			int temp = a[i];
			for (k = i - 1; k > j; k--) {
				a[k + 1] = a[k];// 记录后移
			}
			// 将a[i]放到正确位置上
			a[k + 1] = temp;

		}
	}

	/*
	 * 这样的代码太长了，不够清晰。现在进行一下改写，将搜索和数据后移这二个步 骤合并。即每次a[i]先和前面一个数据a[i-1]比较，如果a[i] >
	 * a[i-1]说明a[0…i]也 是有序的，无须调整。否则就令j=i-1,temp=a[i]。然后一边将数据a[j]向后移动一
	 * 边向前搜索，当有数据a[j]<a[i]时停止并将temp放到a[j + 1]处。
	 */
	public static void insertSort2(int[] a, int n) {
		int i, j;
		for (i = 1; i < n; i++) {
			if (a[i - 1] > a[i]) {
				int temp = a[i];
				for (j = i - 1; j >= 0 && a[j] > temp; j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;
			}
		}
	}

	/*
	 * 再对将a[j]插入到前面a[0…j-1]的有序区间所用的方法进行改写，用数据交换代 替数据后移。如果a[j]前一个数据a[j-1] >
	 * a[j]，就交换a[j]和a[j-1]，再j--直到a[j-1] <= a[j]。这样也可以实现将一个新数据新并入到有序区间。
	 */
	public static void insertSort3(int[] a, int n) {
		int i, j;
		for (i = 1; i < n; i++) {
			for (j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
				swap(a, j, j + 1);
			}
		}
	}

	public static void main(String[] args) {

		int max = 10;
		int[] a = { 2, 4, 1, 5, 7, 6, 1, 9, 0, 2 };
		printArray(a, max);
		insertSort3(a, max);
		printArray(a, max);
		insertSort2(a, max);
		printArray(a, max);
		insertSort1(a, max);
		printArray(a, max);
	}

	private static void printArray(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static void swap(int a[], int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
}
