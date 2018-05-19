package com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.static_factory;

import com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.SmsSender;


public class SendFactory {
	public static SmsSender produceMail(){  
        return new SmsSender();  
    }  
      
    public static SmsSender produceSms(){  
        return new SmsSender();  
    }
}
