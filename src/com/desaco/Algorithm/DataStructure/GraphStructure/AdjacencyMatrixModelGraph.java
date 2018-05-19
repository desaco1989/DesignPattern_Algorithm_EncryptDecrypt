package com.desaco.Algorithm.DataStructure.GraphStructure;

import java.util.ArrayList;

/**
 * 图的节点 边 权重等。
 * 图的表示方法: 
 * DG（有向图）或者DN（有向网）：邻接矩阵、邻接表（逆邻接表--为求入度）、十字链表 
 * UDG（无向图）或者UDN（无向网）：邻接矩阵、邻接表、邻接多重表 
 * 
 * 邻接矩阵模型.https://segmentfault.com/a/1190000002685782
 * 
 * 通过该类构造一个邻接矩阵表示的图，且提供插入结点，插入边，取得某一结点的第一个邻接结点和下一个邻接结点。
 * 
 * @author desaco
 *
 */
public class AdjacencyMatrixModelGraph {
	
	private ArrayList vertexList;// 存储点的链表
	private int[][] edges;// 邻接矩阵，用来存储边
	private int numOfEdges;// 边的数目

	public AdjacencyMatrixModelGraph(int n) {
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
}
