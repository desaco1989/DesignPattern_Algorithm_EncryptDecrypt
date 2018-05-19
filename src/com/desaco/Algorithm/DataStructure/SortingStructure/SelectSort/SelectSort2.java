package com.desaco.Algorithm.DataStructure.SortingStructure.SelectSort;
/**
 * http://zengzhaoshuai.iteye.com/blog/1171921
 * 
 * 对上面的算法改进，每次找到最小的数据的索引，减少交换的次数，提高算法效率
 * @author desaco
 *
 */
public class SelectSort2 {
	public static void selectSort(DataWrap[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;
		// 依次进行n－1趟比较, 第i趟比较将第i大的值选出放在i位置上。
		for (int i = 0; i < arrayLength - 1; i++) {
			// minIndex永远保留本趟比较中最小值的索引
			int minIndex = i;
			// 第i个数据只需和它后面的数据比较
			for (int j = i + 1; j < arrayLength; j++) {
				// 如果第minIndex位置的数据 > j位置的数据
				if (data[minIndex].compareTo(data[j]) > 0) {
					// 将j的值赋给minIndex
					minIndex = j;
				}
			}
			// 每趟比较最多交换一次
			if (minIndex != i) {
				DataWrap tmp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = tmp;
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
