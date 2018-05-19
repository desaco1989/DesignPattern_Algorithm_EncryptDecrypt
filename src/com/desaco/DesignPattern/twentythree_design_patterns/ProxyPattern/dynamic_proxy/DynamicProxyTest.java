package com.desaco.DesignPattern.twentythree_design_patterns.ProxyPattern.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	public static void main(String[] args) {
		
		Sourceable iSourceable = new Source();
        InvocationHandler handler = new DynamicProxy(iSourceable);

        Sourceable proxy = (Sourceable) Proxy.newProxyInstance(
        		iSourceable.getClass().getClassLoader(),
        		iSourceable.getClass().getInterfaces(),
                handler);

        proxy.method();
    }
}
