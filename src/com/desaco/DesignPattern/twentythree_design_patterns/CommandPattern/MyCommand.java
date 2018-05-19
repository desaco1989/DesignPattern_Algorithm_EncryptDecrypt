package com.desaco.DesignPattern.twentythree_design_patterns.CommandPattern;

public class MyCommand implements ICommand {
	private Receiver receiver;

	public MyCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void exe() {
		receiver.action();
	}

}