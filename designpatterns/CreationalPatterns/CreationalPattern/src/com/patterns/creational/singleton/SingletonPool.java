package com.patterns.creational.singleton;

public class SingletonPool {
	private volatile static SingletonPool uniqueInstance = null;
	private SingletonPool() { }
	public static SingletonPool getInstance() {
		if (uniqueInstance == null) {
			synchronized (SingletonPool.class) {
				if (uniqueInstance == null)
					uniqueInstance = new SingletonPool();
			}
		}
		return uniqueInstance;
	}

	/**
	 * Rest of the code to handle pool of connections
	 */
}
