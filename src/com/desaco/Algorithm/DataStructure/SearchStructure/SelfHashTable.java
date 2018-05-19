package com.desaco.Algorithm.DataStructure.SearchStructure;

/**
 * 用Java实现的一个哈希表（散列表）。只是简单实现了一些功能，想借此深入了解哈希表的具体实现。最好的学习方法还是看java源码。
 * 
 * @author desaco
 * 
 */
public class SelfHashTable {
	private int manyItems;
	private Object[] keys;
	private Object[] values;
	private boolean[] hasBeenUsed;

	public SelfHashTable(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity is negative.");
		}
		keys = new Object[capacity];
		values = new Object[capacity];
		hasBeenUsed = new boolean[capacity];
	}

	/**
	 * 判断表是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return manyItems == 0;
	}

	/**
	 * 清空表
	 */
	public synchronized void clear() {
		if (manyItems != 0) {
			for (int i = 0; i < values.length; i++) {
				keys[i] = null;
				values[i] = null;
				hasBeenUsed[i] = false;
			}
			manyItems = 0;
		}
	}

	/**
	 * 判断是否存在指定的关键字
	 * 
	 * @param key
	 * @return
	 */
	public boolean containsKey(Object key) {

		return findIndex(key) != -1;
	}

	public Object get(Object key) {
		int index = findIndex(key);
		if (index != -1) {
			return values[index];
		}
		return null;
	}

	public synchronized Object put(Object key, Object value) {
		int i = findIndex(hash(key));
		Object temp = null;
		if (i != -1) {
			// 表中已经存在该关键字
			temp = values[i];
			values[i] = value;
			// 返回被替换的内容
			return temp;
		} else if (manyItems < values.length) {
			// 表中不存在该关键字且表未满
			i = hash(key);
			// 检查散列码是否有冲突
			if (keys[i] != null) {
				// 散列码有冲突，索引前移
				i = nextIndex(i);
			}
			keys[i] = key;
			values[i] = value;
			hasBeenUsed[i] = true;
			manyItems++;
			return null;
		} else {
			// 表已满
			throw new IllegalStateException("Table is full");
		}
	}

	public synchronized Object remove(Object key) {
		int index = findIndex(key);
		Object result = null;
		if (index != -1) {
			result = values[index];
			keys[index] = null;
			values[index] = null;
			hasBeenUsed[index] = false;
			manyItems--;
		}
		return result;
	}

	/**
	 * 如果在表中找到了指定的关键字，返回指定关键字的索引。否则返回 -1.
	 * 
	 * @param key
	 * @return
	 */
	public int findIndex(Object key) {
		int count = 0;
		int i = hash(key);
		while ((count < values.length) && hasBeenUsed[i]) {
			// 分配的位置已经被使用，而且存在指定的关键字
			if (keys[i].equals(key)) {
				return i;
			}
			// 编辑遍历的次数，当全部元素都遍历完之后，退出遍历
			count++;
			i = nextIndex(i);
		}
		return -1;
	}

	/**
	 * 获取散列码，大小不超过表的大小
	 * 
	 * @param key
	 * @return
	 */
	public int hash(Object key) {
		return Math.abs(key.hashCode()) % values.length;
	}

	public int nextIndex(int index) {
		if (index + 1 == values.length) {
			return 0;
		} else {
			return index + 1;
		}
	}

	/**
	 * 判断指定的位置是否已经被使用
	 * 
	 * @param index
	 * @return
	 */
	public boolean hasBeenUsed(int index) {
		return hasBeenUsed[index];
	}

	/**
	 * 返回该表中有多少对键值对。
	 * 
	 * @return
	 */
	public int size() {
		return manyItems;
	}
}
