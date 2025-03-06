package com.meta;

import common.DoubleLinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.
 *
 * Implement the AllOne class:
 *
 * AllOne() Initializes the object of the data structure.
 * inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
 * dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
 * getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
 * getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
 * Note that each function must run in O(1) average time complexity.
 *
 * Example 1:
 *
 * Input
 * ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
 * [[], ["hello"], ["hello"], [], [], ["leet"], [], []]
 * Output
 * [null, null, null, "hello", "hello", null, "hello", "leet"]
 *
 * Explanation
 * AllOne allOne = new AllOne();
 * allOne.inc("hello");
 * allOne.inc("hello");
 * allOne.getMaxKey(); // return "hello"
 * allOne.getMinKey(); // return "hello"
 * allOne.inc("leet");
 * allOne.getMaxKey(); // return "hello"
 * allOne.getMinKey(); // return "leet"
 *
 * hashMap + double linkedlist
 */



public class AllOne {

    Map<String, Integer> frequency = new HashMap<>();
    Map<String, DoubleLinkedNode<String>> cache = new HashMap<>();

    DoubleLinkedNode<String> head = null, tail = null;


    public AllOne() {

    }

    public void inc(String key) {

        DoubleLinkedNode<String> node = cache.get(key);

        // find prev node and next node;
        if ( node == null ) {
            node = new DoubleLinkedNode<>(key);
            insertIntoFront(node);
        } else {
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
            int f = frequency.get(key);
            DoubleLinkedNode<String> cn = node;
            while ( cn.next != null  ) {
                int fn = frequency.get(node.next.val);
                if ( f > fn ) {
                    String k = cn.val;
                    cn.val = cn.next.val;
                    cn.next.val = k;
                    break;
                }
                cn = cn.next;
            }
        }
    }

    protected void insertIntoFront(DoubleLinkedNode<String> node) {

        if ( head == null ) {
            head = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public void dec(String key) {

        DoubleLinkedNode<String> node = cache.get(key);

        // find prev node and next node;
        if ( node != null ) {

            if ( frequency.get(key) - 1 == 0 ) {
                remove(node);
            }

            frequency.put(key, frequency.get(key) - 1);

            int f = frequency.get(key);
            DoubleLinkedNode<String> cn = node;
            while ( cn.prev != null  ) {
                int fn = frequency.get(node.prev.val);
                if ( f < fn ) {
                    String k = cn.val;
                    cn.val = cn.prev.val;
                    cn.prev.val = k;
                    break;
                }
                cn = cn.prev;
            }
        }


    }

    protected void remove(DoubleLinkedNode<String> node) {
        String key = node.val;
        this.frequency.remove(key);
        this.cache.get(key);


        if ( node.prev != null ) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

    }

    public String getMaxKey() {

        if ( tail != null ) {
            return tail.val;
        } else {
            return null;
        }

    }

    public String getMinKey() {

        if ( head != null ) {
            return head.val;
        } else {
            return null;
        }

    }
}
