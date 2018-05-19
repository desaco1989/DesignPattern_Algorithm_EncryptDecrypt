package com.desaco.Algorithm.DataStructure.GraphStructure;

public class TestAdjacencyMatrixModelGraph {
	public static void main(String args[]) {
		int n = 4, e = 4;// 分别代表结点个数和边的数目
		String labels[] = { "V1", "V1", "V3", "V4" };// 结点的标识
		AdjacencyMatrixModelGraph graph = new AdjacencyMatrixModelGraph(n);
		for (String label : labels) {
			graph.insertVertex(label);// 插入结点
		}
		// 插入四条边 ，边与权重
		graph.insertEdge(0, 1, 2);
		graph.insertEdge(0, 2, 5);
		graph.insertEdge(2, 3, 8);
		graph.insertEdge(3, 0, 7);

		System.out.println("结点个数是：" + graph.getNumOfVertex());
		System.out.println("边的个数是：" + graph.getNumOfEdges());

		graph.deleteEdge(0, 1);// 删除<V1,V2>边
		System.out.println("删除<V1,V2>边后...");
		System.out.println("结点个数是：" + graph.getNumOfVertex());
		System.out.println("边的个数是：" + graph.getNumOfEdges());
	}
}
