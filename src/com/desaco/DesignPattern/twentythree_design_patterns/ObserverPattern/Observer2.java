package com.desaco.DesignPattern.twentythree_design_patterns.ObserverPattern;

public class Observer2 implements IObserver{
	@Override  
    public void update() {  
        System.out.println("observer2 has received!");  
    }
}
