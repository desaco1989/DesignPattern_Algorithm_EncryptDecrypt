package com.desaco.DesignPattern.twentythree_design_patterns.ObserverPattern;

import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstractSubject implements ISubject {
	private Vector<IObserver> vector = new Vector<IObserver>();

	@Override
	public void add(IObserver observer) {
		vector.add(observer);
	}

	@Override
	public void delete(IObserver observer) {
		vector.remove(observer);
	}

	@Override
	public void notifyObservers() {
		Enumeration<IObserver> enumo = vector.elements();
		while (enumo.hasMoreElements()) {
			enumo.nextElement().update();
		}
	}
}
