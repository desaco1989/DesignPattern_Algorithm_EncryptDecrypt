package com.desaco.DesignPattern.twentythree_design_patterns.AdapterPattern.ClassAdapter;

public class AdapterTest {
	public static void main(String[] args) {  
        Targetable target = new Adapter();  
        target.method1();  
        target.method2();  
    } 
}
