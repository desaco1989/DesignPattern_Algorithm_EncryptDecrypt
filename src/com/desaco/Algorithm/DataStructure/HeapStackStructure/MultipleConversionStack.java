package com.desaco.Algorithm.DataStructure.HeapStackStructure;

/**
 * 将10进制正整数num转换为n进制
 * 
 * @author desaco
 *
 */
public class MultipleConversionStack {
	/**
	 * @Title: conversion
	 * @Description: 将10进制正整数num转换为n进制
	 * @param num:
	 *            10进制正整数
	 * @param n:
	 *            n进制
	 * @return 转换后的值
	 */
	private static String conversion(int num, int n) {
		OrderStack<Integer> myStack = new OrderStack<Integer>();
		Integer result = num;
		while (true) {
			// 将余数入栈
			myStack.push(result % n);
			result = result / n;
			if (result == 0) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		// 按出栈的顺序倒序排列即可
		while ((result = myStack.pop()) != null) {
			sb.append(result);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = conversion(13, 8);
		System.out.println(s);
	}

}
