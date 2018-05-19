package com.desaco.DesignPattern.twentythree_design_patterns.DecoratorPattern;

public class Decorator implements Sourceable {
	private Sourceable source;//Decorator持有Sourceable的对象
	public Decorator(Sourceable source) {
		super();
		this.source = source;
	}

	@Override
	public void method() {
		System.out.println("before decorator!");
		source.method();
		System.out.println("after decorator!");
	}
}
