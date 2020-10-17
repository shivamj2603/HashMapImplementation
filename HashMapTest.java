package com.hashtable;
import com.java.datastructures.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashMapTest {
	/**
	 * Usecase1
	 */
	@Test
	void whenPassedGivenString_shouldReturnCountAs2() {
		HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
		String testString= "To be or not to be";
		String[] testWords = testString.toLowerCase().split(" ");
		for (String word : testWords) {
			Integer value = hashMap.get(word);
				if(value == null) {
					value = 1;
				}
			else {
				value = value + 1;
			}
				hashMap.add(word, value);
		}
		assertEquals(2, hashMap.get("to"));
	}
}
