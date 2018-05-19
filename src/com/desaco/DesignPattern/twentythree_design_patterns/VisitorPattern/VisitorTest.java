package com.desaco.DesignPattern.twentythree_design_patterns.VisitorPattern;

public class VisitorTest {
	public static void main(String[] args) {

		Visitor visitor = new MyVisitor();
		ISubject sub = new MySubject();
		sub.accept(visitor);

	}
}
