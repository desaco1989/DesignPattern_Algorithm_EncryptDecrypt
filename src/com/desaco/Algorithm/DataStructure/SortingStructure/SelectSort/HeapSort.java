package com.desaco.Algorithm.DataStructure.SortingStructure.SelectSort;

/**
 * 堆排序利用了大根堆(或小根堆)堆顶记录的关键字最大(或最小)这一特征，使得在当前无序区中选取最大(或最小)关键字的记录变得简单。
 * http://zengzhaoshuai.iteye.com/blog/1171921
 * @author desaco
 * 
 */
public class HeapSort {
	public static void heapSort(DataWrap[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;
		// 循环建堆
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			builMaxdHeap(data, arrayLength - 1 - i);
			// 交换堆顶和最后一个元素
			swap(data, 0, arrayLength - 1 - i);
			System.out.println(java.util.Arrays.toString(data));
		}
	}

	// 对data数组从0到lastIndex建大顶堆
	private static void builMaxdHeap(DataWrap[] data, int lastIndex) {
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k保存当前正在判断的节点
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				// 如果biggerIndex小于lastIndex，即biggerIndex + 1
				// 代表的k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					// 如果右子节点的值较大
					if (data[biggerIndex].compareTo(data[biggerIndex + 1]) < 0) {
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大子节点的值
				if (data[k].compareTo(data[biggerIndex]) < 0) {
					// 交换它们
					swap(data, k, biggerIndex);
					// 将biggerIndex赋给k，开始while循环的下一次循环，
					// 重新保证k节点的值大于其左、右子节点的值。
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	// 交换data数组中i、j两个索引处的元素
	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public static void main(String[] args) {
		DataWrap[] data = { new DataWrap(21, ""), new DataWrap(30, ""),
				new DataWrap(49, ""), new DataWrap(30, "*"),
				new DataWrap(21, "*"), new DataWrap(16, ""),
				new DataWrap(9, "") };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		heapSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
