package com.desaco.DesignPattern.twentythree_design_patterns.AbstractFactory;

public class SendSmsFactory implements Provider{
	@Override  
    public Sender produce() {  
        return new SmsSender();  
    }
}
