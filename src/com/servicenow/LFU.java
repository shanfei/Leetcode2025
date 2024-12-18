package com.servicenow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 *
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 *
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
 * When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item.
 * For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 *
 * To determine the least frequently used key, a use counter is maintained for each key in the cache.
 * The key with the smallest use counter is the least frequently used key.
 *
 * order by frequency and insertTime
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
 * The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 */
class ValueFrequency {
	public int value;
	public int frequency;
	public int t;
	
	public ValueFrequency(int v, int f, int timestamp) {
		this.value = v;
		this.frequency = f;
		this.t = timestamp;
	}
	
	public ValueFrequency() {
		
	}
}

class LFUCache {
	

 	int capacity = 0;
	
	int timestamp = 0;

	Map<Integer, ValueFrequency> content = new HashMap<>();
	
	Map<Integer, Set<Integer>> frequencyMap = new HashMap<>();
	
	int minFrequency = 0;
	
	
    public LFUCache(int capacity) {
    	this.capacity = capacity;
    }

    public int get(int key) {
    	
    	ValueFrequency v = content.get(key);
    	
    	if ( v == null ) {
    		return -1;
    	}
    	
    	increaseFrequency(key, v);
    	
    	return v.value;
    	
    }

    public void put(int key, int value) {
    	
    	ValueFrequency v = content.get(key);
    	
    	if ( v == null ) {

            if ( content.size() == capacity ) { 
        		evicLeastFrequency();
        	}

            v = new ValueFrequency(value, 1, 0);
    		
    	    minFrequency = 1;
        	
    	} else {
    		increaseFrequency(key, v);
            v.value = value;
    	}

    	content.put(key, v);
        Set<Integer> keys = frequencyMap.getOrDefault(v.frequency, new LinkedHashSet<Integer>());
        keys.add(key);
        frequencyMap.put(v.frequency, keys);
    
    }
    
    void evicLeastFrequency() {
         
         Set<Integer> values = frequencyMap.get(minFrequency);

        int firstElementOfLeastFrequency = values.iterator().next();

         values.remove(firstElementOfLeastFrequency);
         content.remove(firstElementOfLeastFrequency);

         if (values.isEmpty()) {
            frequencyMap.remove(minFrequency);
         }
    	
    }
    
    void increaseFrequency(int key, ValueFrequency v) {
    
    	// update frequency map
    	Set<Integer> s = frequencyMap.getOrDefault(v.frequency, new LinkedHashSet<Integer>());
    
    	s.remove(key);

        if (s.isEmpty()) {
            frequencyMap.remove(v.frequency);
            if (minFrequency == v.frequency) {
                   ++minFrequency; 
            }
        }

    	++v.frequency;
        content.put(key, v);
    	s = frequencyMap.getOrDefault(v.frequency, new LinkedHashSet<Integer>( ));
    	s.add(key);
    	frequencyMap.put(v.frequency, s);
    }
}


public class LFU {
	
	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(2);
		lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
		lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
		
		lfu.get(1);      // return 1
		                 // cache=[1,2], cnt(2)=1, cnt(1)=2
		lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
		                 // cache=[3,1], cnt(3)=1, cnt(1)=2
		lfu.get(2);      // return -1 (not found)
		lfu.get(3);      // return 3
		                 // cache=[3,1], cnt(3)=2, cnt(1)=2
		lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
		                 // cache=[4,3], cnt(4)=1, cnt(3)=2
		lfu.get(1);      // return -1 (not found)
		lfu.get(3);      // return 3
		                 // cache=[3,4], cnt(4)=1, cnt(3)=3
		lfu.get(4);      // return 4
	}
}
