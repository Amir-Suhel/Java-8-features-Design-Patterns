package com.java8;

class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}

class Util {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
}

public class Box {

	public static void main(String[] args) {
		Pair<Integer, Integer> p1 = new Pair<>(10, 20);
		Pair<Integer, Integer> p2 = new Pair<>(10, 30);
		
		System.out.println(Util.compare(p1, p2));
	}

}
