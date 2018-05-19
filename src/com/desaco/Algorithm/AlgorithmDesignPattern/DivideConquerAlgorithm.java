package com.desaco.Algorithm.AlgorithmDesignPattern;

/**
 * 
 * 分治算法例子集锦- 
 * 分治算法分三个步骤：
 * 1、分解（Divide）：将原问题分解为若干个规模较小，相互独立，与原问题形式相同的子问题；
 * 2、解决（Conquer）：若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题； 
 * 3、合并（Combine）：将各个子问题的解合并为原问题的解，
 * 
 * 归并排序是一个非常经典规矩的分治法的例子。
 * @author desaco
 *
 */
public class DivideConquerAlgorithm {
	/**
	 * 求x的n次幂
	 * 递归
	 * @param x
	 * @param n
	 * @return
	 */
	static int power(int x, int n)
	{
	    int result;
	    if(n == 1)
	        return x;
	    if( n % 2 == 0)
	        result = power(x, n/2) * power(x, n / 2);
	    else
	        result = power(x, (n+1) / 2) * power(x, (n-1) / 2);

	    return result;
	}
	public static void main(String[] args) {
		int x = 3;
	    int n = 10;

	    System.out.println(power(x, n));
//	    printf("power(%d,%d) = %d \n",x, n, power(x, n));
	}

}
