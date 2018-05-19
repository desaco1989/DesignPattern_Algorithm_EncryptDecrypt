package com.desaco.DesignPattern.twentythree_design_patterns.CommandPattern;

public class Invoker {
	private ICommand command;

	public Invoker(ICommand command) {
		this.command = command;
	}

	public void action() {
		command.exe();
	}
}
