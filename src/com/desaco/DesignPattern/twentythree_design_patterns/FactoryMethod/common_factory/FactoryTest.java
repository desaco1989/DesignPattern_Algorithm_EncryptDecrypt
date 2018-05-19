package com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.common_factory;

import com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.Sender;


public class FactoryTest {
	public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("sms");  
        sender.Send();  
    }
}
