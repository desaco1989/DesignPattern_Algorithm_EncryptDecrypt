package com.desaco.Algorithm.DataStructure.GraphStructure.Depth_Broad;

import java.util.List;

/**
 * 深度优先搜索
 */
public class DFSearch {

	/**
	 * 深度遍历 DFSearch
	 * 
	 * @param node
	 *            当前节点
	 * @param visited
	 *            被访问过的节点列表
	 */
	public void searchTraversing(GraphNode node, List<GraphNode> visited) {
		// 判断是否遍历过
		if (visited.contains(node)) {
			return;
		}

		visited.add(node);
		System.out.println("节点：" + node.getLabel());
		for (int i = 0; i < node.edgeList.size(); i++) {
			searchTraversing(node.edgeList.get(i).getNodeRight(), visited);
		}
	}
}
