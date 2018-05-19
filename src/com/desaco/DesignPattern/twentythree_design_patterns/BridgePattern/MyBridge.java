package com.desaco.DesignPattern.twentythree_design_patterns.BridgePattern;

public class MyBridge extends Bridge {
	public void method() {
		getSource().method();
	}
}
