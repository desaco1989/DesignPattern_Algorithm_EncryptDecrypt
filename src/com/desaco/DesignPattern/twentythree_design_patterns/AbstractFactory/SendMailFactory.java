package com.desaco.DesignPattern.twentythree_design_patterns.AbstractFactory;

public class SendMailFactory implements Provider{
	@Override  
    public Sender produce(){  
        return new MailSender();  
    } 
}
