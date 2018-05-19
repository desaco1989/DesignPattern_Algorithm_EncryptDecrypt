package com.desaco.DesignPattern.twentythree_design_patterns.IteratorPattern;

public class IteratorTest {
	public static void main(String[] args) {

		ICollection collection = new CollectionImp();
		Iterator it = collection.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
