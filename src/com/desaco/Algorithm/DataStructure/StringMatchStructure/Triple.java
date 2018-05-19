package com.desaco.Algorithm.DataStructure.StringMatchStructure;

/**
 * 稀疏矩阵的运算
 * 
 * @author desaco
 * 
 * @param <T>
 */
public class Triple<T> {
	int row, col;
	T v;

	public Triple() {
	}

	public Triple(int row, int col, T v) {
		this.row = row;
		this.col = col;
		this.v = v;
	}
}
