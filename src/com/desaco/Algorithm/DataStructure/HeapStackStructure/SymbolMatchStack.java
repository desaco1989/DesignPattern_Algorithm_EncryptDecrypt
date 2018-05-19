package com.desaco.Algorithm.DataStructure.HeapStackStructure;

/**
 * 检验符号是否匹配. '['和']', '('和')'成对出现时字符串合法. 例如"[][]()", "[[([]([])()[])]]"是合法的;
 * "([(])", "[())"是不合法的
 * 
 * @author desaco
 *
 */
public class SymbolMatchStack {
	/**
	 * @Title: isMatch
	 * @Description: 检验符号是否匹配
	 * @param str
	 *            输入要匹配的字符串
	 * @return 是否匹配
	 */
	public static boolean isMatch(String str) {
		OrderStack<Character> myStack = new OrderStack<Character>();
		char[] arr = str.toCharArray();
		for (char c : arr) {
			Character temp = myStack.pop();
			// 栈为空时只将c入栈
			if (temp == null) {
				myStack.push(c);
			}
			// 配对时c不入栈
			else if (temp == '[' && c == ']') {
			}
			// 配对时c不入栈
			else if (temp == '(' && c == ')') {
			}
			// 不配对时c入栈
			else {
				myStack.push(temp);
				myStack.push(c);
			}
		}
		return myStack.isEmpty();
	}
	public static void main(String[] args) {
		boolean b = isMatch("[[([]([])()[])]]");
		System.out.println(b);
	}
//	public void testMatch() {
//		boolean b = isMatch("[[([]([])()[])]]");
//		System.out.println(b);
//	}
}
