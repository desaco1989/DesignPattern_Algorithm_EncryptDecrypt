package com.desaco.Algorithm.DataStructure.TreeStructure.HuffmanTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 创建哈夫曼树 主要思想：
 *  (1)对List集合中所有节点进行排序。
 *  (2)找出List集合中权值最小的两个节点。
 *  (3)以权值最小的两个节点作为子节点创建新节点。
 *  (4)从List集合中删除权值最小的两个节点，将新节点添加到List集合中。
 * 
 * @author desaco
 *
 */
public class HuffmanTree {
	public static class Node<E> {
		E data;
		double weight;
		Node leftChild;
		Node rightChild;

		public Node(E data, double weight) {
			this.data = data;
			this.weight = weight;
		}

		public String toString() {
			return "Node[data=" + data + ", weight=" + weight + "]";
		}
	}

	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("A", 40.0));
		nodes.add(new Node("B", 8.0));
		nodes.add(new Node("C", 10.0));
		nodes.add(new Node("D", 30.0));
		nodes.add(new Node("E", 10.0));
		nodes.add(new Node("F", 2.0));
		Node root = HuffmanTree.createTree(nodes);
		System.out.println(breadthFirst(root));
	}

	/**
	 * 构造哈夫曼树
	 * 
	 * @param nodes
	 *            节点集合
	 * @return 构造出来的哈夫曼树的根节点
	 */
	private static Node createTree(List<Node> nodes) {
		// 只要nodes数组中还有2个以上的节点
		while (nodes.size() > 1) {
			quickSort(nodes);
			// 获取权值最小的两个节点
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			// 生成新节点，新节点的权值为两个子节点的权值之和
			Node parent = new Node(null, left.weight + right.weight);
			// 让新节点作为权值最小的两个节点的父节点
			parent.leftChild = left;
			parent.rightChild = right;
			// 删除权值最小的两个节点
			nodes.remove(nodes.size() - 1);
			nodes.remove(nodes.size() - 1);
			// 将新生成的父节点添加到集合中
			nodes.add(parent);
		}
		// 返回nodes集合中唯一的节点，也就是根节点
		return nodes.get(0);
	}

	// 将指定数组的i和j索引处的元素交换
	private static void swap(List<Node> nodes, int i, int j) {
		Node tmp;
		tmp = nodes.get(i);
		nodes.set(i, nodes.get(j));
		nodes.set(j, tmp);
	}

	// 实现快速排序算法，用于对节点进行排序。从大到小的排序
	private static void subSort(List<Node> nodes, int start, int end) {
		// 需要排序
		if (start < end) {
			// 以第一个元素作为分界值
			Node base = nodes.get(start);
			// i从左边搜索，搜索大于分界值的元素的索引
			int i = start;
			// j从右边开始搜索，搜索小于分界值的元素的索引
			int j = end + 1;
			while (true) {
				// 找到大于分界值的元素的索引，或i已经到了end处
				while (i < end && nodes.get(++i).weight >= base.weight)
					;
				// 找到小于分界值的元素的索引，或j已经到了start处
				while (j > start && nodes.get(--j).weight <= base.weight)
					;
				if (i < j) {
					swap(nodes, i, j);
				} else {
					break;
				}
			}
			swap(nodes, start, j);
			// 递归左子序列
			subSort(nodes, start, j - 1);
			// 递归右边子序列
			subSort(nodes, j + 1, end);
		}
	}

	public static void quickSort(List<Node> nodes) {
		subSort(nodes, 0, nodes.size() - 1);
	}

	// 广度优先遍历
	public static List<Node> breadthFirst(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		List<Node> list = new ArrayList<Node>();
		if (root != null) {
			// 将根元素入“队列”
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			// 将该队列的“队尾”的元素添加到List中
			list.add(queue.peek());
			Node p = queue.poll();
			// 如果左子节点不为null，将它加入“队列”
			if (p.leftChild != null) {
				queue.offer(p.leftChild);
			}
			// 如果右子节点不为null，将它加入“队列”
			if (p.rightChild != null) {
				queue.offer(p.rightChild);
			}
		}
		return list;
	}
}
