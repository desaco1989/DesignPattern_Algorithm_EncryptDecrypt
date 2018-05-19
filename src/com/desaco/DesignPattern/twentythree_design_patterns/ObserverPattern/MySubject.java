package com.desaco.DesignPattern.twentythree_design_patterns.ObserverPattern;

public class MySubject extends AbstractSubject {

	@Override
	public void operation() {
		System.out.println("update self!");
		notifyObservers();
	}

}
