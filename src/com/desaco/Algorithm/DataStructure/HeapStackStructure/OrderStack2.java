package com.desaco.Algorithm.DataStructure.HeapStackStructure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EmptyStackException;
/**
 * 顺序栈，继承ArrayList
 * @author desaco
 *
 * @param <E>
 */
public class OrderStack2<E> extends ArrayList<E> implements Serializable {
	//
	private static final long serialVersionUID = 2L;

	public OrderStack2() {
		super();
	}

	public OrderStack2(final int initialSize) {
		super(initialSize);
	}

	// 是否为空
	public boolean empty() {
		return isEmpty();
	}

	// 弹出但不删除，出栈
	public E peek() throws EmptyStackException {
		final int n = size();
		if (n <= 0) {
			throw new EmptyStackException();
		} else {
			return get(n - 1);
		}
	}

	// 弹出但不删除，出栈
	public E peek(final int n) throws EmptyStackException {
		final int m = (size() - n) - 1;
		if (m < 0) {
			throw new EmptyStackException();
		} else {
			return get(m);
		}
	}

	// 弹出删除，出栈
	public E pop() throws EmptyStackException {
		final int n = size();
		if (n <= 0) {
			throw new EmptyStackException();
		} else {
			return remove(n - 1);
		}
	}

	// 入栈
	public E push(final E item) {
		add(item);
		return item;
	}

	public int search(final Object object) {
		int i = size() - 1; // Current index
		int n = 1; // Current distance
		while (i >= 0) {
			final Object current = get(i);
			if ((object == null && current == null) || (object != null && object.equals(current))) {
				return n;
			}
			i--;
			n++;
		}
		return -1;
	}
}
