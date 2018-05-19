package com.desaco.Algorithm.DataStructure.GraphStructure;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 深度和广度遍历
 * 
 * https://segmentfault.com/a/1190000002685939
 * 图的遍历，所谓遍历，即是对结点的访问。一般有两种访问策略：深度优先遍历;广度优先遍历.
 * 
 * 深度优先遍历:从初始访问结点出发，我们知道初始访问结点可能有多个邻接结点，深度优先遍历的策略就是首先访问第一个邻接结点，
 * 然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点。总结起来可以这样说：每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
 * 
 * 广度优先遍历:类似于一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点。
 * 
 * @author desaco
 *
 */
public class DepthBroadFirstSearchGraph {
	private ArrayList vertexList;// 存储点的链表
	private int[][] edges;// 邻接矩阵，用来存储边
	private int numOfEdges;// 边的数目

	public DepthBroadFirstSearchGraph(int n) {
		// 初始化矩阵，一维数组，和边的数目
		edges = new int[n][n];
		vertexList = new ArrayList(n);
		numOfEdges = 0;
	}

	// 得到结点的个数
	public int getNumOfVertex() {
		return vertexList.size();
	}

	// 得到边的数目
	public int getNumOfEdges() {
		return numOfEdges;
	}

	// 返回结点i的数据
	public Object getValueByIndex(int i) {
		return vertexList.get(i);
	}

	// 返回v1,v2的权值
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	// 插入结点
	public void insertVertex(Object vertex) {
		vertexList.add(vertexList.size(), vertex);
	}

	// 插入结点
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		numOfEdges++;
	}

	// 删除结点
	public void deleteEdge(int v1, int v2) {
		edges[v1][v2] = 0;
		numOfEdges--;
	}

	// 得到第一个邻接结点的下标
	public int getFirstNeighbor(int index) {
		for (int j = 0; j < vertexList.size(); j++) {
			if (edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	// 根据前一个邻接结点的下标来取得下一个邻接结点
	public int getNextNeighbor(int v1, int v2) {
		for (int j = v2 + 1; j < vertexList.size(); j++) {
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	// 私有函数，深度优先遍历
	private void depthFirstSearch(boolean[] isVisited, int i) {
		// 首先访问该结点，在控制台打印出来
		System.out.print(getValueByIndex(i) + "  ");
		// 置该结点为已访问
		isVisited[i] = true;

		int w = getFirstNeighbor(i);//
		while (w != -1) {
			if (!isVisited[w]) {
				depthFirstSearch(isVisited, w);
			}
			w = getNextNeighbor(i, w);
		}
	}

	// 对外公开函数，深度优先遍历，与其同名私有函数属于方法重载 TODO
//	public void depthFirstSearch() {
//		for (int i = 0; i < getNumOfVertex(); i++) {
//			// 因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
//			if (!isVisited[i]) {
//				depthFirstSearch(isVisited, i);
//			}
//		}
//	}

	// 私有函数，广度优先遍历
	private void broadFirstSearch(boolean[] isVisited, int i) {
		int u, w;
		LinkedList queue = new LinkedList();

		// 访问结点i
		System.out.print(getValueByIndex(i) + "  ");
		isVisited[i] = true;
		// 结点入队列
		queue.addLast(i);
		// queue.addlast(i);
		while (!queue.isEmpty()) {
			u = ((Integer) queue.removeFirst()).intValue();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (!isVisited[w]) {
					// 访问该结点
					System.out.print(getValueByIndex(w) + "  ");
					// 标记已被访问
					isVisited[w] = true;
					// 入队列
					queue.addLast(w);
				}
				// 寻找下一个邻接结点
				w = getNextNeighbor(u, w);
			}
		}
	}

	// 对外公开函数，广度优先遍历 TODO
//	public void broadFirstSearch() {
//		for (int i = 0; i < getNumOfVertex(); i++) {
//			if (!isVisited[i]) {
//				broadFirstSearch(isVisited, i);
//			}
//		}
//	}

	public static void main(String[] args) {
		int n = 8, e = 9;// 分别代表结点个数和边的数目
		String labels[] = { "1", "2", "3", "4", "5", "6", "7", "8" };// 结点的标识
		DepthBroadFirstSearchGraph graph = new DepthBroadFirstSearchGraph(n);
		for (String label : labels) {
			graph.insertVertex(label);// 插入结点
		}
		// 插入九条边
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(2, 5, 1);
		graph.insertEdge(2, 6, 1);
		graph.insertEdge(5, 6, 1);
		graph.insertEdge(1, 0, 1);
		graph.insertEdge(2, 0, 1);
		graph.insertEdge(3, 1, 1);
		graph.insertEdge(4, 1, 1);
		graph.insertEdge(7, 3, 1);
		graph.insertEdge(7, 4, 1);
		graph.insertEdge(6, 2, 1);
		graph.insertEdge(5, 2, 1);
		graph.insertEdge(6, 5, 1);

		System.out.println("深度优先搜索序列为：");
//		graph.depthFirstSearch();
		System.out.println();
		System.out.println("广度优先搜索序列为：");
//		graph.broadFirstSearch();
	}
}
