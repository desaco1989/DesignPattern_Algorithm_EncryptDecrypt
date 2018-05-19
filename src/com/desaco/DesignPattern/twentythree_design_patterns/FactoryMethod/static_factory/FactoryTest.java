package com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.static_factory;

import com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.SmsSender;


public class FactoryTest {
	public static void main(String[] args) {      
        SmsSender sender = SendFactory.produceMail();  
        sender.Send();  
    }
}
