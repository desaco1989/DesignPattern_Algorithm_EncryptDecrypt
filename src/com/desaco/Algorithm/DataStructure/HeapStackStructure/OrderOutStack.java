package com.desaco.Algorithm.DataStructure.HeapStackStructure;

import java.util.Stack;
/**
 * 数据结构：列举所有出栈顺序（java实现）
 * @author desaco
 *
 */
public class OrderOutStack {
	public static void orderList(Stack<String> stack, String result, String input) {
		// 利用对象克隆的方法，先把栈复制下来以免操作后影响下面
		Stack<String> temp = (Stack<String>) stack.clone();
		String subStr = input.substring(0, 1);
		System.out.println("截取的字段："+subStr);
		input = input.substring(1);
		System.out.println("截取的字段222："+input);
		
		temp.push(subStr);
		if (input.length() == 0) {
			while (!temp.isEmpty()) {
				result += temp.pop().toString();
			}
			System.out.println(result);
		} else {
			orderList(temp, result, input);
			while (!temp.isEmpty()) {
				result += temp.pop();
				orderList(temp, result, input);
			}
		}
	}

	public static void main(String[] args) {
		// 测试列举所有出栈顺序
		Stack<String> stack = new Stack<String>();
		orderList(stack, "", "1234");
	}
}
