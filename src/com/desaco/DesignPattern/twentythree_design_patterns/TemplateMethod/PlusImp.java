package com.desaco.DesignPattern.twentythree_design_patterns.TemplateMethod;

public class PlusImp extends AbstractCalculator {

	@Override
	public int calculate(int num1, int num2) {
		return num1 + num2;
	}

}
