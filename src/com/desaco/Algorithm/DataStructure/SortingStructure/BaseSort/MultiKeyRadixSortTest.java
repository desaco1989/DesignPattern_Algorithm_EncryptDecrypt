package com.desaco.Algorithm.DataStructure.SortingStructure.BaseSort;

import java.util.Arrays;

/**
 * 基数排序也称桶排序，是一种当关键字为整数类型时非常高效的排序方法。
 * 
 * 基数排序的思想：设排序的数据元素关键字是M位D进制整数（不足M位的关键字在高位补0）设置D个桶，令其编号分别为0，1，2，...,D-1。首先，
 * 按关键字最低位的数值依次把各数据元素放到相应的桶中
 * ；然后按照桶号从小到大和进入桶中数据元素的先后顺序收集分配在各桶中的数据元素；这样，就形成了数据元素集合的一个新的排列
 * ，称这样一次排序过程为一次基数排序。再对一次基数排序得到的数据元素序列按关键字次低位的数值依次把各数据元素放到相应的桶中
 * ，然后再按照桶号从小到大和进入桶中的数据元素的先后次数分配在各桶中的数据元素。这样重复进行，当完成了第M次基数排序后，就得到排序好的数据元素序列。
 * 
 * @author desaco
 * 
 */
public class MultiKeyRadixSortTest {
	public static void main(String[] args) {
		int[] data = new int[] { 1100, 32,192, 221,345, 12, 342,23 ,444};
		print(data);
		radixSort(data, 10, 4);
		System.out.println("排序后的数组：");
		print(data);
	}

	public static void radixSort(int[] data, int radix, int d) {
		// 缓存数组
		int[] tmp = new int[data.length];
		// buckets用于记录待排序元素的信息
		// buckets数组定义了max-min个桶
		int[] buckets = new int[radix];

		for (int i = 0, rate = 1; i < d; i++) {

			// 重置count数组，开始统计下一个关键字
			Arrays.fill(buckets, 0);
			// 将data中的元素完全复制到tmp数组中
			System.arraycopy(data, 0, tmp, 0, data.length);

			// 计算每个待排序数据的子关键字
			for (int j = 0; j < data.length; j++) {
				int subKey = (tmp[j] / rate) % radix;
				buckets[subKey]++;
			}

			for (int j = 1; j < radix; j++) {
				buckets[j] = buckets[j] + buckets[j - 1];
			}

			// 按子关键字对指定的数据进行排序
			for (int m = data.length - 1; m >= 0; m--) {
				int subKey = (tmp[m] / rate) % radix;
				data[--buckets[subKey]] = tmp[m];
			}
			rate *= radix;
		}

	}

	public static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println();
	}
}
