package com.desaco.DesignPattern.twentythree_design_patterns.InterpreterPattern;

public class MinusImp implements IExpression {
	@Override
	public int interpret(Context context) {
		return context.getNum1() - context.getNum2();
	}
}
