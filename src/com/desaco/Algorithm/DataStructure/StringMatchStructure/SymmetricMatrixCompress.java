package com.desaco.Algorithm.DataStructure.StringMatchStructure;

/**
 * http://www.cnblogs.com/fuck1/p/6059860.html
 * 
 * 特殊矩阵的压缩存储
 * 
 * 对称矩阵的压缩算法---
 * 
 * 特殊矩阵是指这样一类矩阵，其中有许多值相同的元素或有许多零元素，且值相同的元素或零元素的分布有一定规律。一般采用二维数组来存储矩阵元素。但是，对于特殊矩阵
 * ，可以通过找出矩阵中所有值相同元素的数学映射公式，只存储相同元素的一个副本，从而达到压缩存储数据量的目的。
 * 
 * 只存储相同矩阵元素的一个副本。此种压缩存储方法是：找出特殊矩阵数据元素的分布规律，只存储相同矩阵元素的一个副本。
 * 
 * 采用不等长的二维数组
 * Java语言支持不等长的二维数组，对于n阶对称矩阵，也可以通过只申请存储下三角（或上三角）矩阵元素所需的二维数组，来达到压缩存储的目的。
 * 
 * @author desaco
 * 
 */
public class SymmetricMatrixCompress {
	double[] a;// 矩阵元素
	int n; // 矩阵的阶数
	int m;// 一维数组的元素的个数--长度

	public SymmetricMatrixCompress(int n) {
		// 对称矩阵中不重复元素，保存到一维数组中所需要的一维数组的长度
		// 2阶对称矩阵对应(1+2=3)维数组，3阶对称矩阵对应1+2+3=6维数组，
		// 4阶对称矩阵对应1+2+3+4维数组，n阶对称矩阵对应前n项和，
		// 所以一维数组的长度m的值为1,2,3...n的前n项和
		m = n * (n + 1) / 2;
		a = new double[m];
		this.n = n;
	}

	// 通过一个二维数组来初始化
	public void evalute(double[][] b) {
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// i >= j表示只保存下三角元素
				if (i >= j) {
					a[k++] = b[i][j];
				}
			}
		}
	}

	// 通过一个一维数组来初始化,那么这个一维数组就是对称矩阵元素的一个副本
	public void evalute(double[] b) {
		for (int k = 0; k < m; k++) {
			a[k] = b[k];
		}
	}

	// 对称矩阵相加
	public SymmetricMatrixCompress add(SymmetricMatrixCompress b) {
		SymmetricMatrixCompress t = new SymmetricMatrixCompress(n);
		int k;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i >= j) {
					k = i * (i - 1) / 2 + j - 1;
				} else {
					k = j * (j - 1) / 2 + i - 1;
				}
				// 求和
				t.a[k] = a[k] + b.a[k];
			}
		}
		return t;
	}

	// 打印对称矩阵，这个才是关键！！
	public void print() {
		int k;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i >= j) {
					k = i * (i - 1) / 2 + j - 1;
				} else {
					k = j * (j - 1) / 2 + i - 1;
				}
				System.out.print(" " + a[k]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SymmetricMatrixCompress m1 = new SymmetricMatrixCompress(3);
		SymmetricMatrixCompress m2 = new SymmetricMatrixCompress(3);
		SymmetricMatrixCompress m3;

		double[][] a = { { 1, 0, 0 }, { 2, 3, 0 }, { 4, 5, 6 } };
		double[] b = { 1, 2, 3, 4, 5, 6 };

		m1.evalute(a);
		m2.evalute(b);

		m1.print();
		System.out.println();
		System.out.println();
		m2.print();
	}

}
