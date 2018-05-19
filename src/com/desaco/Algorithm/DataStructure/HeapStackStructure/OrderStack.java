package com.desaco.Algorithm.DataStructure.HeapStackStructure;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 顺序栈,数组实现
 * 
 * @author desaco
 *
 */
public class OrderStack<T> implements Serializable {
	//
	private static final long serialVersionUID = 1L;

	private Object[] elementData;// 定义一个数组用于保存顺序栈的元素
	private int size = 0;// 保存顺序栈中元素的当前个数
	private int capacity;// 保存数组的长度

	public OrderStack() {
		elementData = new Object[10];// 默认长度为10的栈
	}

	public OrderStack(int initSize) {
		elementData = new Object[initSize];// 默认长度为10的栈
	}

	public OrderStack(T element) {
		this();
		elementData[0] = element;
		size++;
	}

	public OrderStack(T element, int initSize) {
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}

	/**
	 * @Title: size
	 * @Description: 栈长度
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * @Title: push
	 * @Description: 入栈
	 * @param element
	 */
	public void push(T element) {
		ensureCapacity(size + 1);
		elementData[size++] = element;
	}

	private void ensureCapacity(int minCapacity) {
		// 如果数组的原有长度小于目前所需的长度
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3) / 2 + 1;//以1.5倍的容量自动扩容
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			// minCapacity is usually close to size, so this is a win:
			elementData = Arrays.copyOf(elementData, newCapacity);
		}

	}

	/**
	 * @Title: pop
	 * @Description: 出栈
	 * @return
	 */
	public T pop() {
		if (!isEmpty()) {
			T oldValue = (T) elementData[size - 1];
			// 释放栈顶元素
			elementData[--size] = null;
			return oldValue;
		} else {
			return null;
		}
	}

	/**
	 * @Title: peek
	 * @Description: 返回栈顶元素，但不删除栈顶元素
	 * @return
	 */
	public T peek() {
		if (!isEmpty()) {
			return (T) elementData[size - 1];
		} else {
			throw new IndexOutOfBoundsException("空栈异常");
		}
	}

	/**
	 * @Title: empty
	 * @Description: 判断顺序栈是否为空栈
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @Title: clear
	 * @Description: 清空顺序栈
	 */
	public void clear() {
		// 将底层数组所有元素赋为null
		Arrays.fill(elementData, null);
		size = 0;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (int i = size - 1; i > -1; i--) {
				sb.append(elementData[i].toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
}
