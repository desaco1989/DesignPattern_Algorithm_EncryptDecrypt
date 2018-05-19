package com.desaco.DesignPattern.twentythree_design_patterns.VisitorPattern;

public class MySubject implements ISubject {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		return "love";
	}
}
