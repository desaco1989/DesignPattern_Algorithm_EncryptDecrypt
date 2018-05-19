package com.desaco.DesignPattern.twentythree_design_patterns.FacadePattern;

public class ComputerManage {

	private CPUopt cpu;
	private MemoryOpt memory;
	private DiskOpt disk;

	public ComputerManage() {
		cpu = new CPUopt();
		memory = new MemoryOpt();
		disk = new DiskOpt();
	}

	public void startup() {
		System.out.println("start the computer!");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("start computer finished!");
	}

	public void shutdown() {
		System.out.println("begin to close the computer!");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("computer closed!");
	}
}
