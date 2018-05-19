package com.desaco.DesignPattern.twentythree_design_patterns.StrategyPattern;

public class StrategyTest {
	public static void main(String[] args) {  

        String exp = "2+8";  
        ICalculator cal = new PlusImp();  
        int result = cal.calculate(exp);  
        System.out.println(result);  

    }
}
