package com.desaco.Algorithm.CommonlyUsedAlgorithm.InsertSort;

/**
 * 插入排序：后面元素插入前面元素中
 * 
 * 希尔排序 
 * 
 * 时间复杂度：平均时间是n的1.3次方
 * 空间复杂度：1
 * 
 * @author desaco
 * 
 * 把待排序的数据元素分成若干小组，对同一小组内的数据元素用直接插入排序；
 * 小组的个数逐渐缩小，当完成了所有元素都在一个组内排序后排序过程结束。希尔排序又称作缩小增量排序。
 * 
 * 即分组后进行直接插入排序
 */
public class ShellSort {

	

	public static void main(String[] args) {
//		int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
		int[] b = { 66, 97, 55, 33 };
//		shellSort(b);
		sort(b);
		// for (int i : b)
		// System.out.print(i + " ");
	}
	// 输出打印
		public static void output(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + ",");
			}
		}

	/**
	 * 希尔排序 ，即分组后进行直接插入排序
	 * 
	 * @param arrays
	 *            需要排序的序列
	 */
	public static void sort(int[] arrays) {
		if (arrays == null || arrays.length <= 1) {
			return;
		}
		// 增量 长度为4的数组，
		int incrementNum = arrays.length / 2;//incrementNum= 2
		while (incrementNum >= 1) {
			System.out.println( "--------------------");
			for (int i = 0; i < arrays.length; i++) {//数组长度有多长就比较多少次 4
				// 进行插入排序
				for (int j = i; j < arrays.length - incrementNum; j = j + incrementNum) {
					if (arrays[j] > arrays[j + incrementNum]) {
						int temple = arrays[j];
						arrays[j] = arrays[j + incrementNum];
						arrays[j + incrementNum] = temple;
					}
//					output(arrays);
//					System.out.println( );
				}
				
				
			}
			// 设置新的增量
			incrementNum = incrementNum / 2;
		}
	}
	
	//--------------------------------------------
	public static void shellSort(int[] a) {
		int n = a.length;
		int d = n / 2;
		while (d > 0) {
			for (int i = d; i < n; i++) {
				int j = i - d;
				while (j >= 0 && a[j] > a[j + d]) {
					int tmp = a[j];
					a[j] = a[j + d];
					a[j + d] = tmp;
					j = j - d;
				}
			}
			d = d / 2;
		}
	}

}
