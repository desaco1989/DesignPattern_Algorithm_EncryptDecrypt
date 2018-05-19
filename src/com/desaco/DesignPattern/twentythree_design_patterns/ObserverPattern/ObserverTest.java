package com.desaco.DesignPattern.twentythree_design_patterns.ObserverPattern;

public class ObserverTest {
	public static void main(String[] args) {  

        ISubject sub = new MySubject();  
        sub.add(new Observer1());  
        sub.add(new Observer2());  
        sub.operation();  

    }
}
