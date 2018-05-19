package com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.mutil_factory;

import com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.SmsSender;


public class SendFactory {
	public SmsSender produceMail(){  
        return new SmsSender();  
    }  
      
    public SmsSender produceSms(){  
        return new SmsSender();  
    }
}
