package com.desaco.Algorithm.DataStructure.QueueStructure;

/**
 * 所谓的优先级队列，即队列中数据项的值有序。 优先级队列数组实现： 数组头为队列尾，数组尾为队列头； 队列中数据项的值从队列头至队列尾越来越大；
 * 
 * 由于插入操作有可能需要移动数组中的数据项，故插入操作的时间复杂度为(0+N)/2，即O(N)； 删除操作的时间复杂度为O(1)
 *
 * 优先队列
 * 
 * @author desaco
 *
 */
public class PriorityQueue {
	private int[] data;
	private int size;

	public PriorityQueue(int size) {
		data = new int[size];
		this.size = 0;
	}

	public void push(int toInsert) throws Exception {
		if (size == data.length)
			throw new Exception("Queue is full!");
		if (size == 0) {
			data[0] = toInsert;
		} else {
			int i = size - 1;
			for (; i >= 0; i--) {
				if (data[i] < toInsert) {
					data[i + 1] = data[i];
				} else {
					break;
				}
			}
			data[i + 1] = toInsert;
		}
		size++;
	}

	public int pop() throws Exception {
		if (this.size == 0)
			throw new Exception("Queue is empty!");
		return data[--size];
	}

	public int peek() throws Exception {
		if (this.size == 0)
			throw new Exception("Queue is empty!");
		return data[size - 1];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean isFull() {
		return (size == data.length);
	}
}
