package com.desaco.Algorithm.AlgorithmDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * http://www.cnblogs.com/longhs/archive/2013/06/14/3135433.html
 * 
 * 输入一个字符串，输出该字符串中字符的所有组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc。
 * 
 * 
 * @author desaco
 *
 */
public class CombinationAlgorithm {
	public static void combiantion(char chs[]) {
		if (chs == null || chs.length == 0) {
			return;
		}
		List<Character> list = new ArrayList();
		for (int i = 1; i <= chs.length; i++) {
//			System.out.println("遍历的字符有："+i);
			combine(chs, 0, i, list);
		}
	}

	// 从字符数组中第begin个字符开始挑选number个字符加入list中
	public static void combine(char[] cs, int begin, int number, List<Character> list) {
		if (number == 0) {
			System.out.println(list.toString());
			return;
		}
		if (begin == cs.length) {
			return;
		}
		list.add(cs[begin]);
		System.out.println("begin="+cs[begin]);
		combine(cs, begin + 1, number - 1, list);
//		System.out.println("begin="+cs[begin]);
		list.remove((Character) cs[begin]);
		combine(cs, begin + 1, number, list);
	}

	public static void main(String args[]) {
		char chs[] = { 'a', 'b', 'c' };
		combiantion(chs);
	}
}
