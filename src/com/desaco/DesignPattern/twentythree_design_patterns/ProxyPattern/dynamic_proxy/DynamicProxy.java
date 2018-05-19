package com.desaco.DesignPattern.twentythree_design_patterns.ProxyPattern.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{
	
	private Object obj;
	public DynamicProxy(Object obj){
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result = method.invoke(obj, args);
        after();
        return result;
	}
	
	private void before() {
        System.out.println("Begin");
    }

    private void after() {
        System.out.println("End");
    }
}
