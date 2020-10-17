package com.hashtable;
import com.java.datastructures.*;
import java.util.ArrayList;

public class LinkedHashMap<E, V> {
	private int numOfBuckets;
	ArrayList<LinkedList<E>> bucketArray;
	public LinkedHashMap() {
		this.numOfBuckets = 10;
		this.bucketArray = new ArrayList(numOfBuckets);
		for (int iteration = 0; iteration < numOfBuckets; iteration++) {
			this.bucketArray.add(null);
		}
	}
	/**
	 * Function Returns The Value for specific Element
	 * 
	 * @param key
	 * @return
	 */
	public V get(E key) {
		int index = this.getBucketIndex(key);
		LinkedList<E> linkedList = this.bucketArray.get(index);
		if (linkedList == null) {
			return null;
		}
		HashNode<E, V> hashNode = (HashNode) linkedList.search(key);
		V value;
		if (hashNode == null) {
			value = null;
		} else {
			value = hashNode.getValue();
		}
		return value;
	}
	/**
	 * Adding the list to index or updating the node in the list
	 * 
	 * @param key
	 * @param value
	 */
	public void add(E key, V value) {
		int index = this.getBucketIndex(key);
		LinkedList<E> linkedList = this.bucketArray.get(index);
		if (linkedList == null) {
			linkedList = new LinkedList<>();
			this.bucketArray.set(index, linkedList);
		}
		HashNode<E, V> hashNode = (HashNode) linkedList.search(key);
		if (hashNode == null) {
			hashNode = new HashNode<>(key, value);
			linkedList.append(hashNode);
		} else {
			hashNode.setValue(value);
		}
	}
	/**
	 * Find the Hash Code
	 * 
	 * @param key
	 * @return
	 */
	private int getBucketIndex(E key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numOfBuckets;
		return index;
	}
	public String toString() {
		return "MyLinkedHashMap List{" + bucketArray + "}";
	}
	public void remove(E key) {
		int index = this.getBucketIndex(key);
		LinkedList<E> list = this.bucketArray.get(index);
		if (list == null) {
			System.out.println("The key does not exist");
			return;
		}
		HashNode<E, V> hashNode = (HashNode) list.search(key);
		list.remove(hashNode.getKey());
	}
}
