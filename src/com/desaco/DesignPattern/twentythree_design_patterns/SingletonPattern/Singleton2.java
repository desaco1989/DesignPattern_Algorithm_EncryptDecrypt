package com.desaco.DesignPattern.twentythree_design_patterns.SingletonPattern;

import java.util.Vector;

public class Singleton2 {
	private static Singleton2 instance = null;
	private Vector properties = null;

	public Vector getProperties() {
		return properties;
	}

	private Singleton2() {
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new Singleton2();
		}
	}

	public static Singleton2 getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}

	public void updateProperties() {
		Singleton2 shadow = new Singleton2();
		properties = shadow.getProperties();
	}
}
