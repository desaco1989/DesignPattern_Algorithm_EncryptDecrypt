package com.desaco.Algorithm.DataStructure.LinearTableStructure;

/**
 * 线性表的接口
 * 
 * @author desaco
 *
 */
public interface ILinearTable<E> {
	
	boolean isEmpty(); // 判断线性表是否为空，若空返回ture

	int length(); // 返回线性表长度

	E get(int index); // 返回序号为index的对象，index初值为0

	E set(int index, E element); // 设置序号为index对象为element，返回原对象

	boolean add(int index, E element); // 插入element对象，插入后对象序号为index

	boolean add(E element); // 插入element对象，插入位置没有约定

	E remove(int index); // 移去序号为index的对象，放回被移去对象

	void clear(); // 清空线性表
}
