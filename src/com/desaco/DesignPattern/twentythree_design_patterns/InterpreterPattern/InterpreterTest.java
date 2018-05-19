package com.desaco.DesignPattern.twentythree_design_patterns.InterpreterPattern;

public class InterpreterTest {
	public static void main(String[] args) {

		// 计算9+2-8的值
		int result = new MinusImp().interpret((new Context(new PlusImp().interpret(new Context(9, 2)), 8)));

		System.out.println(result);

	}
}
