package com.desaco.Algorithm.DataStructure.HeapStackStructure;

/**
 * http://wushan0801-139-com.iteye.com/blog/1450072
 * 
 * 优先队列是至少允许插入和删除最小者这两个操作的数据结构。其中，对于优先队列的实现，二叉堆是很常见的。
 * 堆是一棵被完全填满的二叉树，可能例外是底层，底层上的元素从左到右依次填入。
 * 而且如果使用数组表示二叉堆，那么对于数组上的任意位置i上的元素，其左儿子的位置是2i，
 * 右儿子在左儿子后的单元（2i+1）中，他的父亲则在位置[i/2]上。 
 * 
 * 二叉堆的实现(数组实现)
 * 
 * @author desaco
 *
 */
public class BinaryHeap {
	private static final int DEAFAULT_CAPACITY = 100;
	private int currentSize;// 堆中的元素个数
	private Compare[] array;// 存储堆中的元素使用数组存储方式

	public BinaryHeap() {
		this(DEAFAULT_CAPACITY);
	}

	public BinaryHeap(int capacity) {
		currentSize = 0;
		array = new Compare[capacity + 1];

	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean isFull() {
		return currentSize == array.length - 1;
	}

	public void makeEmpty() {
		currentSize = 0;
	}

	/**
	 * 插入使用“上移”法
	 * 
	 * @param x
	 */
	public void insert(Compare x) {
		if (isFull())
			throw new RuntimeException("溢出");

		int hole = ++currentSize;
		for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
			array[hole] = array[hole / 2];
		array[hole] = x;
	}

	/**
	 * 使用下溢法进行删除操作
	 * 
	 * @return
	 */
	public Compare deleteMin() {
		if (isEmpty())
			return null;

		Compare minItem = array[1];
		array[1] = array[currentSize--];
		percolateDown(1);

		return minItem;
	}

	private void percolateDown(int hole) {
		int child = 0;
		Compare tmp = array[hole];

		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;
			if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
				child++;
			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = tmp;
	}
}

class Compare implements Comparable<Object> {

	public int compareTo(Object o) {
		return ((Integer) this.compareTo(o));
	}
}
