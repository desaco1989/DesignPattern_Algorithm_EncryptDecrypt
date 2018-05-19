package com.desaco.DesignPattern.twentythree_design_patterns.PrototypePattern;

public class SimplePrototype implements Cloneable {
	public Object clone() throws CloneNotSupportedException {
		SimplePrototype proto = (SimplePrototype) super.clone();
		return proto;
	}
}
