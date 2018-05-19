package com.desaco.Algorithm.DataStructure.TreeStructure.LinkTree;

import java.util.LinkedList;
import java.util.List;
/**
 * 编写链式存储的树类，这里采用递归求解树的深度
 * @author desaco
 *
 * @param <T>
 */
public class MyLinkTree<T> {
	private final int DEFAUL_SIZE = 10;
	private int size;
	private int count;

	private Node<T>[] nodes;

	@SuppressWarnings("unchecked")
	public MyLinkTree() {
		this.size = this.DEFAUL_SIZE;
		this.nodes = new Node[this.size];
		this.count = 0;
	}

	@SuppressWarnings("unchecked")
	public MyLinkTree(int size) {
		this.size = size;
		this.nodes = new Node[this.size];
		this.count = 0;
	}

	public MyLinkTree(T data) {
		this();
		Node<T> node = new Node<T>(data);
		this.nodes[0] = node;
		this.count++;
	}

	public MyLinkTree(Node<T> root) {
		this();
		this.nodes[0] = root;
		this.count++;
	}

	public void add(Node<T> node, Node<T> parent) {
		SubNode son = new SubNode();
		for (int i = 0; i < this.size; i++) {
			if (this.nodes[i] == null) {
				this.nodes[i] = node;
				son.setLocation(i);
				break;
			}
		}

		// 往链表中添加子节点位置
		SubNode next = parent.getSon();
		if (next != null) {
			while (next.getNext() != null) {
				next = next.getNext();
			}
			next.setNext(son);
		} else {
			parent.setSon(son);
		}

		this.count++;
	}

	public int size() {
		return this.count;
	}

	public Node<T> getRoot() {
		return this.nodes[0];
	}

	// 获取指定节点的子节点
	public List<Node<T>> getSon(Node<T> parent) {
		List<Node<T>> list = new LinkedList<Node<T>>();
		SubNode son = parent.getSon();
		while (son != null) {
			list.add(this.nodes[son.getLocation()]);
			son = son.getNext();
		}
		return list;
	}

	// 获取树的深度，通过递归的方式来解决
	public int getDepth(Node<T> node) {
		SubNode son = node.getSon();
		if (son == null) {
			return 1;
		} else {
			int max = 0;
			while (son != null) {
				int temp = this.getDepth(this.nodes[son.getLocation()]);
				max = temp > max ? temp : max;
				son = son.getNext();
			}
			// 为什么要max+1？
			return max + 1;
		}
	}

	public int deep() {
		int max = 0;
		for (int i = 0; i < this.count; i++) {
			int temp = this.getDepth(this.nodes[i]);
			max = max > temp ? max : temp;
		}
		return max;
	}
}
