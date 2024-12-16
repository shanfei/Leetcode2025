package com.servicenow;

import java.util.HashMap;
import java.util.Map;

class LRUCacheNode {

    int key;
    int value;
    LRUCacheNode next;
    LRUCacheNode prev;

    public LRUCacheNode(int key, int value, LRUCacheNode next, LRUCacheNode prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public LRUCacheNode(LRUCacheNode n) {
        this.key = n.key;
        this.value = n.value;
        this.next = n.next;
        this.prev = n.prev;
    }

    public LRUCacheNode() {
    }
}

class LRUCache {

    final int capacity;

    Map<Integer, LRUCacheNode> m = new HashMap<>();

    LRUCacheNode head;
    LRUCacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LRUCacheNode();
        tail = new LRUCacheNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        LRUCacheNode value = this.m.get(key);

        int v = -1;

        // this is O(1)
        if ( value != null ) {

            v = value.value;

            // remove current node by copy next node value to current node, update tail
            remove(value);

            // move current node to the tail
            add(value);

        }

        return v;

    }

    void remove(LRUCacheNode node) {
        LRUCacheNode prevNode = node.prev;
        LRUCacheNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.prev = null;
        node.next = null;
    }

    void add(LRUCacheNode node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public void put(int key, int value) {

        if (m.containsKey(key)) {
            LRUCacheNode oldNode = m.get(key);
            remove(oldNode);
        }

        LRUCacheNode lruCacheNode = new LRUCacheNode(key, value, null, null);

        m.put(key, lruCacheNode);

        add(lruCacheNode);

        if ( m.size() > capacity ) {
            // evict the last entry
           m.remove(head.next.key);
           remove(head.next);

        }


    }
}


/**
 *
 * leetcode 146
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 * use double linkedList for O(1) insert and remove performance
 *
 *
 */
public class LRU {


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);

        lruCache.put(2, 2);// cache is {1=1, 2=2}

        System.out.println(lruCache.get(1));    // return 1

        lruCache.put(3, 3);// LRU key was 2, evicts key 2, cache is {1=1, 3=3}

        System.out.println(lruCache.get(2));    // returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}

        System.out.println(lruCache.get(1));    // return -1 (not found)
        System.out.println(lruCache.get(3));    // return 3
        System.out.println(lruCache.get(4));    // return 4
    }


}
