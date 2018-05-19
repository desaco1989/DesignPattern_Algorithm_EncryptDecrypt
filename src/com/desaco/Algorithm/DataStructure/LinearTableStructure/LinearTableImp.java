package com.desaco.Algorithm.DataStructure.LinearTableStructure;

/**
 * 线性表是其组成元素间具有线性关系的一种线性结构，对线性表的基本操作主要有插入、删除、查找、替换等，
 * 这些操作可以在线性表的任何位置进行。线性表可以采用顺序存储结构和链式存储结构表示。
 * 
 * 线性表的顺序存储结构.ArrayList的底层实现是数组，而HashMap底层是一个数组+链表实现。其基本原理是：定义一个LinkedList的数组,然后将数据存储到这个链表数组内
 * 
 * @author desaco
 *
 * 使用数组实现链表算法，重写了toString()方法
 */
public class LinearTableImp<E> implements ILinearTable<E> {
	
	private Object[] table; // 对象数组，私有成员
	private int n; // 顺序表长度

	public LinearTableImp(int capacity) // 构造方法，创建置顶容量的空表
	{
		this.table = new Object[Math.abs(capacity)];
		this.n = 0;
	}

	public LinearTableImp() // 指定空表的默认容量
	{
		this(16);
	}

	public boolean isEmpty() // 判断顺序表是否为空，若空返回true
	{
		return this.n == 0;
	}

	public int length() // 返回顺序表长度
	{
		return this.n;
	}

	public E get(int index) // 返回index(初值为0)位置的对象，若序号无效，返回null
	{
		if (index >= 0 && index < this.n) {
			return (E) this.table[index];
		}
		return null;
	}

	public E set(int index, E element) // 设置index位置的对象为element，若操作成功，放回原对象，否则返回null
	{
		if (index >= 0 && index < this.n && element != null) {
			E old = (E) this.table[index];
			this.table[index] = element;
			return old;
		}
		return null;
	}

	public boolean add(int index, E element) // 在index位置插入element对象，若操作成功返回true，不能插入null
	{
		if (element == null) // 不能插入null
		{
			return false;
		}
		if (this.n == table.length) // 若数组满，则需要扩充顺序表容量
		{
			Object[] temp = this.table;
			this.table = new Object[temp.length * 2]; // 重新申请一个容量更大的数组，以2倍的容量自动扩容
			for (int i = 0; i < temp.length; i++) {
				this.table[i] = temp[i];
			}
		}

		if (index < 0) // 下标容错
		{
			index = 0;
		}
		if (index > this.n) {
			index = this.n;
		}
		for (int j = this.n - 1; j >= index; j--) // 元素后移，平均移动n/2
		{
			this.table[j + 1] = this.table[j];
		}
		this.table[index] = element;
		this.n++;
		return true;
	}

	public boolean add(E element) // 在顺序表最后插入element对象
	{
		return add(this.n, element);
	}

	public E remove(int index) // 移去index位置的对象，若操作成功，则返回被移去的对象，否者返回null
	{
		if (this.n != 0 && index >= 0 && index < this.n) {
			E old = (E) this.table[index];
			for (int j = index; j < this.n - 1; j++) // 元素前移，平均移动n/2
			{
				this.table[j] = this.table[j + 1];
			}
			this.table[this.n - 1] = null;
			this.n--;
			return old;
		}
		return null;
	}

	public void clear() // 清空顺序表
	{
		if (this.n != 0) {
			for (int i = 0; i < this.n; i++) {
				this.table[i] = null;
			}
			this.n = 0;
		}
	}

	public String toString() // 返回显示所有元素的字符串，形式为(,)
	{
		String str = "(";
		if (this.n != 0) {
			for (int i = 0; i < this.n - 1; i++) {
				str += this.table[i].toString() + ",";
			}
			str += this.table[this.n - 1].toString();
		}
		return str + ")";
	}
}
