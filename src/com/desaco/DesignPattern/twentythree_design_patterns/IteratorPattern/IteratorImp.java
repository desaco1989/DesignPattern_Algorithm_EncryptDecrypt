package com.desaco.DesignPattern.twentythree_design_patterns.IteratorPattern;

public class IteratorImp implements Iterator {
	
	private ICollection collection;
	private int pos = -1;

	public IteratorImp(ICollection collection) {
		this.collection = collection;
	}

	@Override

	public Object previous() {
		if (pos > 0) {
			pos--;
		}
		return collection.get(pos);
	}

	@Override

	public Object next() {

		if (pos < collection.size() - 1) {
			pos++;
		}
		return collection.get(pos);

	}

	@Override

	public boolean hasNext() {

		if (pos < collection.size() - 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override

	public Object first() {
		pos = 0;
		return collection.get(pos);
	}
}
