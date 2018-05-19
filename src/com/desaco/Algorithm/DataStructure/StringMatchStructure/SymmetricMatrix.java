package com.desaco.Algorithm.DataStructure.StringMatchStructure;
/**
 * http://blog.csdn.net/tanjie_123/article/details/53009563
 * 
 * 特殊矩阵的压缩存储
 * 
 * @author desaco
 *
 */
public class SymmetricMatrix {
	private static final int N = 3;
	int[][] a = new int[N][N];
	int[] SA = new int[N * (N + 1) / 2];

	public void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				a[i][j] = a[j][i] = i + j;
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				SA[count] = a[i][j];
				count++;
			}
		}

	}

	public void printMatrix() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int find(int i, int j) {
		return SA[i * (i + 1) / 2 + j];
	}

	public void printSA() {
		for (int i : SA) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		SymmetricMatrix matrix = new SymmetricMatrix();
		matrix.init();
		matrix.printMatrix();
		matrix.printSA();
		int result = matrix.find(0, 0);
		System.out.println();
		System.out.println(result);
	}
}
