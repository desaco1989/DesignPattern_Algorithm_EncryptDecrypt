package com.desaco.Algorithm.DataStructure.GraphStructure.ShortestPath;

import java.util.Stack;

/**
 * 
 * Dijkatra 迪克斯特拉 ,双栈算术表达式求值算法 ,
 * 
 * 迪克斯特拉（Dijkstra）算法是典型最短路算法，用于计算一个节点到其他所有节点的最短路径。主要特点是以起始点为中心向外层层扩展，直到扩展到终点为止。
 * Dijkstra算法能得出最短路径的最优解，但由于它遍历计算的节点很多，所以效率低。
 * 
 * http://blog.csdn.net/u012063703/article/details/54427493
 * 
 * 在图形应用中，常常需要求从图中某个结点至其余各结点的最短路径，如对于一个物流配送系统计算从配送中心到各订货点的最短路径。
 * 
 * Dijkstra's Algorithm 基本思想： 若给定带权有向图G=(V,E)和源顶点v0，构筑一个源集合S，将v0加入其中。 ①
 * 对差集V\S中个顶点vi，逐一计算从v0 至它的距离 D(v0 , vi ),若该两顶点之间没有边，则其距离为无穷大。求出其中距离最短
 * 的顶点w，将其加入到集合 S 中。 ② 重新计算 v0 至差集 V\S 中各顶点的距离 D（v0, vi ）= Min(D(v0, vi ), D(v0,
 * w ) + C(w, vi)).其中C（w, vi ）是顶点w 与 vi 之 间边上的费用。 ③ 重复 步骤①②。直至所有的顶点都加到集合S 中为止。
 * 
 * @author desaco
 *
 */
public class DijkatraAlgorithm {
	static double evaluate(String tmp) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		for (int i = 0; i < tmp.length(); i++) {
			String s = String.valueOf(tmp.charAt(i));

			// 运算符压入 操作符栈
			if (s.equals("("))
				;
			else if (s.equals("+"))
				ops.push(s);
			else if (s.equals("-"))
				ops.push(s);
			else if (s.equals("*"))
				ops.push(s);
			else if (s.equals("/"))
				ops.push(s);
			else if (s.equals(")")) {
				// 遇到右括号开始计算
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+"))
					v = vals.pop() + v;
				if (op.equals("-"))
					v = vals.pop() - v;
				if (op.equals("*"))
					v = vals.pop() * v;
				if (op.equals("/"))
					v = vals.pop() / v;

				vals.push(v);
			} else {
				// 数字压入 操作数栈
				vals.push(Double.parseDouble(s));
			}

		}
		return vals.pop();
	}

	public static void main(String[] args) {
		String t = "(1+((2+3)*(4*5)))";
		double ret = evaluate(t);
		System.out.println(ret);
	}
}
