package com.desaco.Algorithm.DataStructure.ArrayStructure;

import java.util.ArrayList;
import java.util.List;

public class DynamicStaticArray {
	//
	private void staticArray() {
		int score2[] = new int[3]; // 静态初始化
	}

	private void dynamicArray() {
		int score[] = null;
		score = new int[3];
		// 通过循环为数组动态赋值,且赋奇数值 ，动态初始化
		for (int i = 0; i < score.length; i++) {
			score[i] = i * 2 + 1;
		}
		
		//ArrayList 会总动扩容 。ArrayList、Vector及LinkedList
		List<String> list = new ArrayList<String>();
	}
	
	
}
