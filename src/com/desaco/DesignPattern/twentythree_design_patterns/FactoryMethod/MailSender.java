package com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod;

public class MailSender implements Sender{

	@Override
	public void Send() {
		System.out.println("this is mailSender!");
	}

}
