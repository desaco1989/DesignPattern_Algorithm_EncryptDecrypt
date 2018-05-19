package com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.common_factory;

import com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.MailSender;
import com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.Sender;
import com.desaco.DesignPattern.twentythree_design_patterns.FactoryMethod.SmsSender;


public class SendFactory {
	public Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确的类型!");
			return null;
		}
	}
}
