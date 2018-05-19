package com.desaco.DesignPattern.twentythree_design_patterns.SingletonPattern;

public class Singleton3 {
	
	private volatile static Singleton3 instance = null;

	private Singleton3() {
	}

	public static Singleton3 getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton3();
			}
		}
		return instance;
	}
}
