package com.sd.hasing.consistent;

import java.util.HashMap;
import java.util.Map;

public class CacheMachine {
	private Map<Integer, String> cache = new HashMap<Integer, String>();
	private int position;
	private String name;
	
	public CacheMachine(int position, String name) {
		this.position = position;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public int getPosition() {
		return position;
	}
	
	public Map<Integer, String> getCache() {
		return cache;
	}
	public void putItem(Integer key, String value) {
		cache.put(key, value);
	}
}
