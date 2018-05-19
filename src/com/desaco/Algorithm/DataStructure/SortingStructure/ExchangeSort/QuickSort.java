package com.desaco.Algorithm.DataStructure.SortingStructure.ExchangeSort;

/**
 * http://www.cnblogs.com/vanezkw/archive/2012/06/21/2557685.html
 * 
 * 快速排序（Quicksort）是对冒泡排序的一种改进。由C. A. R. Hoare在1962年提出。
 * 
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 
 * @author desaco
 * 
 */
public class QuickSort {
	static void quicksort(int n[], int left, int right) {
		int dp;
		if (left < right) {
			dp = partition(n, left, right);
			quicksort(n, left, dp - 1);
			quicksort(n, dp + 1, right);
		}
	}

	static int partition(int n[], int left, int right) {
		int pivot = n[left];
		while (left < right) {
			while (left < right && n[right] >= pivot)
				right--;
			if (left < right)
				n[left++] = n[right];
			while (left < right && n[left] <= pivot)
				left++;
			if (left < right)
				n[right--] = n[left];
		}
		n[left] = pivot;
		return left;
	}
	public static void main(String[] args) {
		System.out.println("Hello World");
        int[] a = {12,20,5,16,15,1,30,45,23,9};
        int start = 0;
        int end = a.length-1;
        quicksort(a,start,end);
        for(int i = 0; i<a.length; i++){
             System.out.println(a[i]);
         }
        
//		int score[]={94,86,25,78,19,302,21,44,73,2,500,100,22,55,66,25}; //12
//		quicksort(score,0,15);
	}
}
