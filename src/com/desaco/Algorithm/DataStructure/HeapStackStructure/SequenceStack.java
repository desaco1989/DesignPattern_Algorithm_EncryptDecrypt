package com.desaco.Algorithm.DataStructure.HeapStackStructure;
/**
 * 顺序栈
 * @author desaco
 *
 */
public class SequenceStack {
	private int STACK_INIT_SIZE = 5;// 栈的原始大小
	private int INCREMENT = 1;// 栈的增量大小

	private Object[] Stack = null;
	private int base;
	private int top;
	private int stacksize;

	/**
	 * 初始化栈
	 */
	void initStack() {
		Stack = new Object[STACK_INIT_SIZE];
		base = 0;
		top = 0;
		stacksize = 0;
	}

	/**
	 * 入栈
	 */
	void push(Object o) {
		if (top - base >= STACK_INIT_SIZE) {
			System.out.println("扩充栈");
			STACK_INIT_SIZE = STACK_INIT_SIZE + INCREMENT;
			Object[] temp = new Object[STACK_INIT_SIZE];
			for (int i = 0; i < stacksize; i++) {
				temp[i] = Stack[i];
			}
			Stack = null;
			Stack = temp;
		}
		Stack[stacksize] = o;
		stacksize++;
		top++;
	}

	/**
	 * 出栈
	 */
	Object pop() {
		Object o = null;
		if (top == base) {
			System.out.println("栈中没有元素！返回null");
		} else {
			o = Stack[--top];
			stacksize--;
		}
		return o;
	}

	/**
	 * 取栈顶元素
	 */
	Object getTop() {
		Object o = null;
		if (top == base) {
			System.out.println("栈中没有元素！返回null");
		} else {
			o = Stack[top - 1];
		}
		return o;
	}

	/**
	 * 打印栈
	 */
	void print() {
		System.out.print("打印栈：");
		for (int i = 0; i < stacksize; i++) {
			System.out.print(Stack[i] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SequenceStack sStack = new SequenceStack();
		sStack.initStack();
		sStack.pop();
		sStack.push(1);
		sStack.push(2);
		sStack.push(3);
		sStack.push(4);
		sStack.push(5);
		sStack.push(6);
		sStack.push(3);
		sStack.print();

		sStack.pop();
		sStack.pop();
		sStack.pop();
		sStack.pop();
		sStack.print();

		System.out.println("取栈顶元素：" + sStack.getTop());
		sStack.print();
	}
}
