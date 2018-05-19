package com.desaco.Algorithm.DataStructure.TreeStructure.OrderTree;

public class TestArrayBinaryTree {
	public static void main(String[] args) {
		ArrayBinaryTree<String> binTree = new ArrayBinaryTree<String>(4, "根");
		binTree.add(0, "0右", false);
		binTree.add(2, "2右", false);
		binTree.add(2, "2左", true);

		binTree.add(0, "0左", true);
		binTree.add(1, "1左", true);
		System.out.println(binTree);

		System.out.println(binTree.getLeft(2));
		System.out.println(binTree.getParent(6));
	}
}
