package com.desaco.DesignPattern.twentythree_design_patterns.ObserverPattern;

public interface ISubject {
	/* 增加观察者 */
	public void add(IObserver observer);

	/* 删除观察者 */
	public void delete(IObserver observer);

	/* 通知所有的观察者 */
	public void notifyObservers();

	/* 自身的操作 */
	public void operation();
}
