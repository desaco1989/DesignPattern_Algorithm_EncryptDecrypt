package com.desaco.DesignPattern.twentythree_design_patterns.IteratorPattern;

public interface ICollection {
	public Iterator iterator();

	/* 取得集合元素 */
	public Object get(int i);

	/* 取得集合大小 */
	public int size();
}
