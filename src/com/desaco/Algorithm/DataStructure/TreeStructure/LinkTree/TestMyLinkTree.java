package com.desaco.Algorithm.DataStructure.TreeStructure.LinkTree;

public class TestMyLinkTree {
	public static void main(String[] args) {
		Node<String> root = new Node<String>("A");
		Node<String> b = new Node<String>("B");
		Node<String> c = new Node<String>("C");
		Node<String> d = new Node<String>("D");
		Node<String> e = new Node<String>("E");
		Node<String> f = new Node<String>("F");
		Node<String> g = new Node<String>("G");
		Node<String> h = new Node<String>("H");
		MyLinkTree<String> tree = new MyLinkTree<String>(root);
		
		tree.add(b, root);
		tree.add(c, root);
		tree.add(d, root);
		tree.add(e, b);
		tree.add(f, b);
		tree.add(g, f);
		tree.add(h, g);
		System.out.println(tree.size());
		
		System.out.println(tree.deep());
		System.out.println(tree.getSon(b));
		System.out.println(tree.getRoot());
	}
}
