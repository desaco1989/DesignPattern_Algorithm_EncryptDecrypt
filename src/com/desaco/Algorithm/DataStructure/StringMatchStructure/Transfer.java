package com.desaco.Algorithm.DataStructure.StringMatchStructure;

import java.util.Scanner;
/**
 * 稀疏矩阵的运算;
 * 
 * @author desaco
 *
 */
public class Transfer {
	public static void main(String[] args) {
		int i, j, k, l;
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入矩阵的行数，列数，非零元的个数：");
		int mu, nu, tu;
		mu = scan.nextInt();
		nu = scan.nextInt();
		tu = scan.nextInt();
		Mat M1 = new Mat(mu, nu, tu);
		Mat M2 = new Mat(nu, mu, tu);
		System.out.println("请输入矩阵的三元组：");
		for (i = 1; i <= tu; i++) {
			M1.data[i].row = scan.nextInt();
			M1.data[i].col = scan.nextInt();
			M1.data[i].v = scan.nextInt();
		}
		System.out.println("您输入的矩阵为：");
		M1.display();
		// 增加两个向量
		int num[] = new int[nu + 1];// M1中第col列中非零元的个数
		int col, row, t;
		for (col = 1; col <= nu; col++) {
			num[col] = 0;
		}
		for (t = 1; t <= tu; t++) {
			num[M1.data[t].col]++;
		}
		int cpot[] = new int[nu + 1];// M1中第col列的第一个非零元在M2.data中的位置。
		cpot[1] = 1;
		for (col = 2; col <= nu; col++) {
			cpot[col] = cpot[col - 1] + num[col - 1];
		}
		int p, q;// 实现转置
		for (p = 1; p <= tu; p++) {
			col = M1.data[p].col;
			q = cpot[col];
			M2.data[q].row = M1.data[p].col;
			M2.data[q].col = M1.data[p].row;
			M2.data[q].v = M1.data[p].v;
			cpot[col]++;
		}
		System.out.println("转置后的矩阵为：");
		M2.display();

	}
}
