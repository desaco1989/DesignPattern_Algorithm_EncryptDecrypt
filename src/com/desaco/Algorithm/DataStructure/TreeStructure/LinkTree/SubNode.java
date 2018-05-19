package com.desaco.Algorithm.DataStructure.TreeStructure.LinkTree;

/**
 * 首先定义一个用于存储子节点位置的节点类
 * 
 * @author desaco
 *
 */
public class SubNode {
	private int location;
	private SubNode next;

	public SubNode() {
		this.location = 0;
		this.next = null;
	}

	public SubNode(int location) {
		this.location = location;
		this.next = null;
	}

	public SubNode(int location, SubNode next) {
		this.location = location;
		this.next = next;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public SubNode getNext() {
		return next;
	}

	public void setNext(SubNode next) {
		this.next = next;
	}
}
