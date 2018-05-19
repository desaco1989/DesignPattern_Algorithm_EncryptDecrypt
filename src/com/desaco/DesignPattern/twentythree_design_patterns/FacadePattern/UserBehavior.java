package com.desaco.DesignPattern.twentythree_design_patterns.FacadePattern;

public class UserBehavior {
	public static void main(String[] args) {  

		ComputerManage computer = new ComputerManage();  
        computer.startup();  
        computer.shutdown();  

    }
}
