package com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.mutil_factory;

import com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.SmsSender;


public class FactoryTest {
	public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        SmsSender sender = factory.produceMail();  
        sender.Send();  
    }
}
