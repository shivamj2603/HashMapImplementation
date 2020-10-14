package com.hashtable;
import com.java.datastructures.*;
public class HashNode<E, V> implements INode<E> {
	private E key;
	public V value;
	public HashNode<E, V> next;
	public HashNode(E key, V value) {
		this.key = key;
		this.value = value;
	}
	@Override
	public E getKey() {
		return this.key;
	}
	@Override
	public void setKey(E key) {
		this.key = key;	
	}
	@Override
	public INode<E> getNext() {
		return this.next;
	}
	@Override
	public void setNext(INode<E> next) {
		this.next = (HashNode<E, V>) next;	
	}
	public V getValue() {
		return this.value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}
