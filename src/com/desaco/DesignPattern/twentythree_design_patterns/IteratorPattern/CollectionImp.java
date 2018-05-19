package com.desaco.DesignPattern.twentythree_design_patterns.IteratorPattern;

public class CollectionImp implements ICollection {
	//数组实现
	public String string[] = { "A", "B", "C", "D", "E" };

	@Override
	public Iterator iterator() {
		return new IteratorImp(this);
	}

	@Override
	public Object get(int i) {
		return string[i];
	}

	@Override
	public int size() {
		return string.length;
	}
}
