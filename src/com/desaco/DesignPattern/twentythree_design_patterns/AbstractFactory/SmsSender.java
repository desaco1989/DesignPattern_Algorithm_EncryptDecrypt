package com.desaco.DesignPattern.twentythree_design_patterns.AbstractFactory;

public class SmsSender implements Sender{

	@Override
	public void Send() {
		System.out.println("this is SmsSender!");
	}

}
