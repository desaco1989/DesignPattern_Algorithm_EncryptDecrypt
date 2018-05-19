package com.desaco.Algorithm.DataStructure.LinearTableStructure;

/**
 * 单向链表 线性表的初始化、获取线性表长度、获取指定索引处元素、根据值查找、插入、删除、清空等操作。
 * 还有双向链表
 * 
 * 线性链表的实现
 * @author desaco
 *
 */
public class LinkList<T> {
	// 定义一个内部类Node，代表链表的节点
	private class Node {
		private T data;// 保存数据
		private Node next;// 指向下个节点的引用

		// 无参构造器
		public Node() {
		}

		// 初始化全部属性的构造器
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node header;// 保存头结点
	private Node tail;// 保存尾节点
	private int size;// 保存已含有的节点数

	// 创建空链表
	public LinkList() {
		header = null;
		tail = null;
	}

	// 已指定数据元素创建链表，只有一个元素
	public LinkList(T element) {

		header = new Node(element, null);
		// 只有一个节点，header,tail都指向该节点
		tail = header;
		size++;
	}

	// 返回链表的长度
	public int length() {
		return size;
	}

	// 获取指定索引处的元素
	public T get(int index) {
		return this.getNodeByIndex(index).data;
	}

	// 获取指定位置的节点
	private Node getNodeByIndex(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("索引超出线性表范围");
		}

		Node current = header;// 从header开始遍历

		for (int i = 0; i < size && current != null; i++, current = current.next) {
			if (i == index) {
				return current;
			}
		}

		return null;
	}

	// 按值查找所在位置
	public int locate(T element) {
		Node current = header;

		for (int i = 0; i < size && current != null; i++, current = current.next) {
			if (current.data.equals(element)) {
				return i;
			}
		}

		return -1;
	}

	// 指定位置插入元素
	public void insert(T element, int index) {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("索引超出线性表范围");
		}

		// 如果是空链表
		if (header == null) {
			add(element);
		} else {
			// 当index为0时，即在链表头处插入
			if (0 == index) {
				addAtHead(element);
			} else {
				Node prev = getNodeByIndex(index - 1);// 获取前一个节点
				// 让prev的next指向新节点，新节点的next指向原来prev的下一个节点
				prev.next = new Node(element, prev.next);
				size++;
			}
		}
	}

	// 在尾部插入元素
	public void add(T element) {
		// 如果链表是空的
		if (header == null) {
			header = new Node(element, null);

			// 只有一个节点，headwe,tail都该指向该节点
			tail = header;
		} else {
			Node newNode = new Node(element, null);// 创建新节点
			tail.next = newNode;// 尾节点的next指向新节点
			tail = newNode;// 将新节点作为尾节点
		}

		size++;
	}

	// 头部插入
	public void addAtHead(T element) {
		// 创建新节点，让新节点的next指向header
		// 并以新节点作为新的header
		Node newNode = new Node(element, null);
		newNode.next = header;
		header = newNode;

		// 若插入前是空表
		if (tail == null) {
			tail = header;
		}

		size++;
	}

	// 删除指定索引处的元素
	public T delete(int index) {

		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("索引超出线性表范围");
		}

		Node del = null;

		// 若要删除的是头节点
		if (index == 0) {
			del = header;
			header = header.next;
		} else {
			Node prev = getNodeByIndex(index - 1);// 获取待删除节点的前一个节点

			del = prev.next;// 获取待删除节点

			prev.next = del.next;

			del.next = null;// 将被删除节点的next引用置为空
		}

		size--;
		return del.data;
	}

	// 删除最后一个元素
	public T remove() {
		return delete(size - 1);
	}

	// 判断线性表是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 清空线性表
	public void clear() {
		// 将header,tail置为null
		header = null;
		tail = null;
		size = 0;
	}

	public String toString() {

		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = header; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}

	}

	public static void main(String[] args) {
		// 测试构造函数
		LinkList<String> list = new LinkList("好");
		System.out.println("测试构造函数:" + list);

		// 测试添加元素
		list.add("ni");
		list.add("没");
		System.out.println("测试添加元素:" + list);

		// 在头部添加
		list.addAtHead("五月");
		System.out.println("在头部添加:" + list);

		// 在指定位置添加
		list.insert("摩卡", 2);
		System.out.println("在指定位置添加:" + list);

		// 获取指定位置处的元素
		System.out.println("第2个元素是（从0开始计数）：" + list.get(2));

		// 返回元素索引
		System.out.println("摩卡在的位置是：" + list.locate("摩卡"));
		System.out.println("moka所在的位置：" + list.locate("moka"));

		// 获取长度
		System.out.println("当前线性表的长度：" + list.length());

		// 判断是否为空
		System.out.println("判断是否为空:" + list.isEmpty());

		// 删除最后一个元素
		list.remove();
		System.out.println("调用remove()后：" + list);

		// 获取长度
		System.out.println("当前线性表的长度：" + list.length());

		// 删除指定位置处元素
		list.delete(3);
		System.out.println("删除第4个元素后：" + list);

		// 获取长度
		System.out.println("当前线性表的长度：" + list.length());

		// 清空
		list.clear();
		System.out.println("清空:" + list);

		// 判断是否为空
		System.out.println("判断是否为空:" + list.isEmpty());
	}

}
