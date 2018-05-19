package com.desaco.Algorithm.DataStructure.HeapStackStructure;

import java.io.Serializable;
/**
 * 链式栈
 * @author desaco
 *
 * @param <T>
 */
public class LinkStack<T> implements Serializable {
	//
	private static final long serialVersionUID = 3L;

	private class Node {
		private T data; // 保存节点的数据
		private Node next; // 指向下个节点的引用
		public Node() {

		}

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node top; // 保存该链栈的栈顶元素
	private int size = 0; // 保存该链栈中已包含的节点数,即栈的长度

	public LinkStack() {
		top = null;
	}

	public LinkStack(T element) {
		top = new Node(element, null);
		size++;
	}

	/**
	 * @Title: size
	 * @Description: 栈的长度
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
		top = new Node(element, top);
		size++;
	}

	/**
	 * @Title: pop
	 * @Description: 出栈
	 * @return
	 */
	public T pop() {
		Node oldTop = top;
		top = top.next;
		oldTop.next = null;
		size--;
		return oldTop.data;
	}

	/**
	 * @Title: peek
	 * @Description: 访问栈顶元素
	 * @return
	 */
	public T peek() {
		return top.data;
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
		top = null;// 将栈所有元素赋为null
		size = 0;
	}

	public String toString() {
		// 链栈为空链栈时
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = top; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
}
