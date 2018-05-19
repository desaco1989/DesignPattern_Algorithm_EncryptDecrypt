package com.desaco.Algorithm.DataStructure.RecursiveStructure;

/**
 * 斐波纳契数列（Fibonacci Sequence）用递归和非递归方法求n的阶乘
 * 
 * @author desaco
 * 
 */
public class FactorialAlgorithm {
	
	// 非循环递归方法
	public static int factorial(int m) {
		if (m < 0) {
			return 0;
		} else if (m == 1) {
			return 1;
		} else if (m > 1) {
			return m * factorial(m - 1);
		}
		return 0;
	}

	// 循环递归方法
	public static int cycleFactorial(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n > 1) {
			int sum = 1;
			for (int i = 2; i <= n; i++) {
				sum = sum * i;
			}
			return sum;
		}
		return 0;
	}

	public static void main(String[] args) {
		int a = factorial(5);
		System.out.println("factorial=" + a);
		int b = cycleFactorial(5);
		System.out.println("cycleFactorial=" + b);
	}
}
