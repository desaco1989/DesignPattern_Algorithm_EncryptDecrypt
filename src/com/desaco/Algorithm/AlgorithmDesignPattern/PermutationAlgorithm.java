package com.desaco.Algorithm.AlgorithmDesignPattern;

/**
 * http://www.cnblogs.com/longhs/archive/2013/06/14/3135433.html
 * 
 * 排列问题
 * 
 * 关于字符串排列的问题,通过递归简单的实现,
 * 
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、
 * cab和cba。
 * 
 * @author desaco
 *
 */
public class PermutationAlgorithm {
	public static void permutation(char[] ss, int i) {
		if (ss == null || i < 0 || i > ss.length) {
			return;
		}
		if (i == ss.length) {
			System.out.println(new String(ss));
		} else {
			for (int j = i; j < ss.length; j++) {
				char temp = ss[j];// 交换前缀,使之产生下一个前缀
				ss[j] = ss[i];
				ss[i] = temp;
				permutation(ss, i + 1);
				temp = ss[j]; // 将前缀换回来,继续做上一个的前缀排列.
				ss[j] = ss[i];
				ss[i] = temp;
			}
		}
	}

	public static void main(String args[]) {
		char[] ss = { 'a', 'c', 'b', 'd' };
		permutation(ss, 0);
	}
}
