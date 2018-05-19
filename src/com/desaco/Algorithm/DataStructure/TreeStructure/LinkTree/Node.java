package com.desaco.Algorithm.DataStructure.TreeStructure.LinkTree;
/**
 * 然后定义一个用于存储节点信息的节点类
 * @author desaco
 *
 * @param <T>
 */
public class Node<T> {
	private T data;
	private SubNode son;

	public Node() {

	}

	public Node(T data) {
		this.data = data;
		this.son = null;
	}

	public Node(T data, SubNode son) {
		this.data = data;
		this.son = son;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SubNode getSon() {
		return son;
	}

	public void setSon(SubNode son) {
		this.son = son;
	}
}
