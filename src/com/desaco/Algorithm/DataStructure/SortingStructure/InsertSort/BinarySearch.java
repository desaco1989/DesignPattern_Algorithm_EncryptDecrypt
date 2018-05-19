package com.desaco.Algorithm.DataStructure.SortingStructure.InsertSort;

/**
 * 算法优化：
 * 二分查找插入排序的原理：是直接插入排序的一个变种，在有序区中查找新元素插入位置时，为了减少元素比较次数提高效率，采用二分查找算法进行插入位置的确定。
 * 
 * @author desaco
 *
 */
public class BinarySearch {
	/**
	 * 二分查找插入排序
	 * 
	 * @param sortList
	 */
	public static void insertSort3(Integer[] sortList) {
		int len = sortList.length;
		for (int i = 1; i < len; i++) {
			if (sortList[i] < sortList[i - 1]) {
				// 二分查找在有序区寻找插入的位置
				int index = binarySearchIndex(sortList, i - 1, sortList[i]);
				if (i != index) {
					int temp = sortList[i];
					// 后移元素，腾出arr[index]位置
					for (int j = i - 1; j >= index; j--)
						sortList[j + 1] = sortList[j];
					// 将 arr[i] 放到正确位置上
					sortList[index] = temp;
				}
			}
		}
	}

	/**
	 * 二分查找要插入的位置得index
	 * 
	 * @param sortList
	 * @param maxIndex
	 * @param data
	 * @return
	 */
	private static int binarySearchIndex(Integer[] sortList, int maxIndex, int data) {
		int iBegin = 0;
		int iEnd = maxIndex;
		int middle = -1;
		while (iBegin <= iEnd) {
			middle = (iBegin + iEnd) / 2;
			if (sortList[middle] > data) {
				iEnd = middle - 1;
			} else {
				iBegin = middle + 1;// 如果是相同元素，也是插入在后面的位置
			}
		}
		return iBegin;
	}
}
