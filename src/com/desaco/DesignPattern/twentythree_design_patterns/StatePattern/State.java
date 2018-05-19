package com.desaco.DesignPattern.twentythree_design_patterns.StatePattern;

public class State {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void method1() {
		System.out.println("execute the first opt!，value="+value);
	}

	public void method2() {
		System.out.println("execute the second opt!，value="+value);
	}
}
