package com.desaco.Algorithm.DataStructure.HeapStackStructure;

/**
 * 输入行中字符'#'表示退格, '@'表示之前的输入全都无效
 * 
 * @author desaco
 *
 */
public class LineEditStack {
	/**
	 * @Title: lineEdit
	 * @Description: 行编辑
	 * @param input
	 * @return
	 */
	private static String lineEdit(String input) {
		OrderStack<Character> myStack = new OrderStack<Character>();
		char[] arr = input.toCharArray();
		for (char c : arr) {
			if (c == '#') {
				myStack.pop();
			} else if (c == '@') {
				myStack.clear();
			} else {
				myStack.push(c);
			}
		}

		StringBuilder sb = new StringBuilder();
		Character temp = null;
		while ((temp = myStack.pop()) != null) {
			sb.append(temp);
		}
		// 反转字符串
		sb.reverse();
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = lineEdit("abcd#dsa@#usera#22#8");
		System.out.println(s);
	}

}
