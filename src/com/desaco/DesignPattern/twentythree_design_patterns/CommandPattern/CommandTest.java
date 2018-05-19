package com.desaco.DesignPattern.twentythree_design_patterns.CommandPattern;

public class CommandTest {
	public static void main(String[] args) {  

        Receiver receiver = new Receiver();  
        ICommand cmd = new MyCommand(receiver);
        
        Invoker invoker = new Invoker(cmd);  
        invoker.action();  

    } 
}
