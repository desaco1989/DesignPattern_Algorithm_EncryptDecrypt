package com.desaco.Algorithm.DataStructure.ArrayStructure;

/**
 * 稀疏矩阵的运算;
 * 
 * @author desaco
 * 
 */
public class Mat {
	final int MAXSIZE = 10;
	int mu, nu, tu;
	Triple<Integer> data[] = new Triple[MAXSIZE + 1];// Java不支持泛型数组

	public Mat(int mu, int nu, int tu) {
		this.mu = mu;
		this.nu = nu;
		this.tu = tu;
		for (int i = 1; i <= MAXSIZE; i++)
			data[i] = new Triple();
	}

	public void display() {
		int i, j, k, m, n, count = 0;
		for (i = 1; i <= mu; i++) {
			for (j = 1; j <= nu; j++) {
				for (k = 1; k <= tu; k++) {
					if (i == data[k].row && j == data[k].col) {
						System.out.print(data[k].v + " ");
						count = -1;
						break;
					}
				}
				if (count != -1)
					System.out.print("0 ");
				count = 0;
			}
			System.out.println();
		}
	}
}
