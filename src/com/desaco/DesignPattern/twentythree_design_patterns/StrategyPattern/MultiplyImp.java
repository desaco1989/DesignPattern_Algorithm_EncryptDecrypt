package com.desaco.DesignPattern.twentythree_design_patterns.StrategyPattern;

public class MultiplyImp extends AbstractCalculator implements ICalculator {

	@Override
	public int calculate(String exp) {
		int arrayInt[] = split(exp, "\\*");
		return arrayInt[0] * arrayInt[1];
	}

}
