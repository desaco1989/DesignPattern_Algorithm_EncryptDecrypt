package com.desaco.DesignPattern.twentythree_design_patterns.VisitorPattern;

public class MyVisitor implements Visitor {

	@Override
	public void visit(ISubject sub) {
		System.out.println("visit the subject：" + sub.getSubject());
	}

}
