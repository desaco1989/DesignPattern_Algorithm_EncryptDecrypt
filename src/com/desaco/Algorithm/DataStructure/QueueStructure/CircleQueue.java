package com.desaco.Algorithm.DataStructure.QueueStructure;

/**
 * http://blog.csdn.net/wuwenxiang91322/article/details/12259099
 * 头尾相接的顺序存储结构称为循环队列（circular queue）。 循环队列中需要注意的几个重要问题：
 * ①队空的判定条件，队空的条件是front=rear；
 * ②队满的判定条件，（rear+1）%QueueSize=front。QueueSize为队列初始空间大小。
 * 
 * 队列的修改是依先进先出的原则进行的。新来的成员总是加入队尾，每次离开的成员总是队列头上的（不允许中途离队）。
 * 
 * 数组实现
 * @author desaco
 *
 * @param <E>
 */
public class CircleQueue<E> {
	// 对象数组，队列最多存储a.length-1个对象
	E[] a;
	// 默认初始化大小
	private static final int DEFAULT_SIZE = 10;
	// 对首下标
	int front;
	// 队尾下标
	int rear;

	public CircleQueue() {
		this(DEFAULT_SIZE);
	}

	/**
	 * 初始化指定长度的队列
	 * 
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CircleQueue(int size) {
		a = (E[]) (new Object[size]);
		front = 0;
		rear = 0;
	}

	/**
	 * 将一个对象追加到队列尾部
	 * 
	 * @param obj
	 * @return 队列满时返回false,否则返回true
	 */
	public boolean enqueue(E obj) {
		if ((rear + 1) % a.length == front) {
			return false;
		} else {
			a[rear] = obj;
			rear = (rear + 1) % a.length;
			return true;
		}
	}

	/**
	 * 队列头部出队
	 * 
	 * @return
	 */
	public E dequeue() {
		if (rear == front)
			return null;
		else {
			E obj = a[front];
			front = (front + 1) % a.length;
			return obj;
		}
	}

	/**
	 * 队列长度
	 * 
	 * @return
	 */
	public int size() {
		return (rear - front) & (a.length - 1);
	}

	// 队列长度（另一种方法）
	public int length() {
		if (rear > front) {
			return rear - front;
		} else
			return a.length - 1;
	}

	/**
	 * 判断是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return rear == front;
	}

	public static void main(String[] args) {
		CircleQueue<String> queue = new CircleQueue<String>(4);
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		System.out.println("size=" + queue.size());
		int size = queue.size();
		System.out.println("*******出栈操作*******");
		for (int i = 0; i < size; i++) {
			System.out.print(queue.dequeue() + " ");
		}

	}
}
