package com.desaco.DesignPattern.twentythree_design_patterns.TemplateMethod;

public class TemplateTest {
	public static void main(String[] args) {  

        String exp = "8+8";  
        AbstractCalculator cal = new PlusImp();  
        int result = cal.calculate(exp, "\\+");  
        System.out.println(result);  

    } 
}
