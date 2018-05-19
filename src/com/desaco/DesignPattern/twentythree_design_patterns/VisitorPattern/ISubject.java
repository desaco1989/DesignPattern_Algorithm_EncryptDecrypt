package com.desaco.DesignPattern.twentythree_design_patterns.VisitorPattern;

public interface ISubject {
	
	public void accept(Visitor visitor);  
    public String getSubject();
}
