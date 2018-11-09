package com.desaco.Algorithm.CommonlyUsedAlgorithm.ExchangeSort;

/**
 * 希尔排序
 * 
 * @author desaco
 *
 */
public class ShellSort {

	/**
	 * 希尔排序
	 * 
	 * @param arrays
	 *            需要排序的序列
	 */
	public static void sort(int[] arrays) {
		if (arrays == null || arrays.length <= 1) {
			return;
		}
		// 增量
		int incrementNum = arrays.length / 2;
		while (incrementNum >= 1) {
			for (int i = 0; i < arrays.length; i++) {
				// 进行插入排序
				for (int j = i; j < arrays.length - incrementNum; j = j + incrementNum) {
					if (arrays[j] > arrays[j + incrementNum]) {
						int temple = arrays[j];
						arrays[j] = arrays[j + incrementNum];
						arrays[j + incrementNum] = temple;
					}
				}
			}
			// 设置新的增量
			incrementNum = incrementNum / 2;
		}
	}

}
