package com.desaco.DesignPattern.twentythree_design_patterns.ObserverPattern;

public class Observer1 implements IObserver{
	@Override  
    public void update() {  
        System.out.println("observer1 has received!");  
    } 
}
