package com.hashtable;
import com.java.datastructures.*;

public class HashMap<E, V> {
	public LinkedList<E> linkedList; 
	public HashMap() {
		this.linkedList = new LinkedList<E>();
	}
	public V get(E key) {
		HashNode<E, V> hashNode = (HashNode<E, V>) this.linkedList.search(key);
		return hashNode == null ? null : hashNode.getValue();
	}
	public void add(E key, V value) {
		HashNode<E, V> hashNode = (HashNode<E, V>) this.linkedList.search(key);
		if(hashNode == null) {
			hashNode = new HashNode<E, V>(key, value);
			this.linkedList.append(hashNode);
		}
		else {
			hashNode.setValue(value);
		}
	}
}
