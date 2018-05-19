package com.desaco.DesignPattern.twentythree_design_patterns.ResponsibilityChainPattern;

public class MyHandler extends AbstractHandler implements IHandler {
	
	private String name;

	public MyHandler(String name) {
		this.name = name;
	}

	@Override
	public void operator() {
		System.out.println(name + "deal!");
		if (getHandler() != null) {
			getHandler().operator();
		}
	}
}
