package com.desaco.DesignPattern.twentythree_design_patterns.AbstractFactory;

public class Test {
	public static void main(String[] args) {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();
	}
}
