package com.desaco.Algorithm.DataStructure.GraphStructure.Depth_Broad;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static MyGraph graph = null;

	/**
	 * 初始化图的结构 DFSearch
	 */
	private static void initGraph() {
		if (graph == null) {
			graph = new MyGraph();
		}
		graph.initGraph();
	}

	public static void main(String[] args) {
		initGraph();
		List<GraphNode> visited = new ArrayList<GraphNode>();
		// 深度优先搜索结果
		System.out.println("深度优先搜索结果：");
		DFSearch dfs = new DFSearch();
		dfs.searchTraversing(graph.getGraphNodes().get(0), visited);
		// 广度优先搜索结果
		System.out.println("广度优先搜索结果：");
		BFSearch bfs = new BFSearch();
		bfs.searchTraversing(graph.getGraphNodes().get(0));
	}

}
