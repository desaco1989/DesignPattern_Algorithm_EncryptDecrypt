package com.desaco.DesignPattern.twentythree_design_patterns.ResponsibilityChainPattern;

public abstract class AbstractHandler {
	private IHandler handler;

	public IHandler getHandler() {
		return handler;
	}

	public void setHandler(IHandler handler) {
		this.handler = handler;
	}
}
