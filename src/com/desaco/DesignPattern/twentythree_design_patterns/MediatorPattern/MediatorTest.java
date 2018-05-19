package com.desaco.DesignPattern.twentythree_design_patterns.MediatorPattern;

public class MediatorTest {
	public static void main(String[] args) {  

        Mediator mediator = new MyMediator();  
        mediator.createMediator();  
        mediator.workAll();  

    } 
}
