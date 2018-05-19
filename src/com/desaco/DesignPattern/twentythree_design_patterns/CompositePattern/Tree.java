package com.desaco.DesignPattern.twentythree_design_patterns.CompositePattern;

public class Tree {
	
	TreeNode root = null;

	public Tree(String name) {
		root = new TreeNode(name);
	}

	public static void main(String[] args) {
		
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		nodeB.add(nodeC);
		
		Tree tree = new Tree("A");
		tree.root.add(nodeB);

		System.out.println("build the tree finished!");
	}
}
