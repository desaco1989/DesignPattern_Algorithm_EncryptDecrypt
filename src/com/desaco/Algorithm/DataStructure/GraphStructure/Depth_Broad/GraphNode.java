package com.desaco.Algorithm.DataStructure.GraphStructure.Depth_Broad;

import java.util.ArrayList;
import java.util.List;

/**
 * 图中的节点
 */
public class GraphNode {

	public List<GraphEdge> edgeList = null;
	
	private String label = "";
	
	public GraphNode(String label) {
		this.label = label;
		if (edgeList == null) {
			edgeList = new ArrayList<GraphEdge>();
		}
	}
	
	/**
	 * 给当前节点添加一条边
	 * GraphNode
	 * @param edge
	 * 			添加的边
	 */
	public void addEdgeList(GraphEdge edge) {
		edgeList.add(edge);
	}
	
	public String getLabel() {
		return label;
	}
}
