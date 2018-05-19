package com.desaco.DesignPattern.twentythree_design_patterns.BridgePattern;

public class SourceSub1 implements Sourceable {
	@Override
	public void method() {
		System.out.println("this is the first sub!");
	}
}
