package com.leetcode.amazon

import java.util.PriorityQueue

/**
 *  2 heaps
 */
class MedianFinder() {

    // maintain a pq with top is largest element in the queue
    val leftPriorityQueue = PriorityQueue<Int>()

    // maintain a pq with top is smallest element in the queue
    val rightPriorityQueue = PriorityQueue<Int> { p1, p2 -> p2 - p1 }

    // O(N)
    fun addNum(num: Int) {

        if ( leftPriorityQueue.isEmpty() || leftPriorityQueue.peek() <= num ) {
            leftPriorityQueue.add(num);
        } else {
            rightPriorityQueue.add(num);
        }

        // balance 2 queue
        balance()

    }

    fun balance() {

        if ( Math.abs(leftPriorityQueue.size - rightPriorityQueue.size) <= 1 ) {
            return
        }

        if ( leftPriorityQueue.size + 1 < rightPriorityQueue.size  ) {
            leftPriorityQueue.offer(rightPriorityQueue.poll())
        } else if ( rightPriorityQueue.size < leftPriorityQueue.size ) {
            rightPriorityQueue.offer(leftPriorityQueue.poll())
        }


    }

    // O(1) 
    fun findMedian(): Double {

       if ( leftPriorityQueue.size == rightPriorityQueue.size ) {
           return ( leftPriorityQueue.peek().toDouble() + rightPriorityQueue.peek().toDouble() ) / 2
       } else {
           return leftPriorityQueue.peek().toDouble()
       }
    }

}

fun main() {
    val m = MedianFinder();
    m.addNum(12);
    m.addNum(10);
    m.addNum(13);
    m.addNum(11);
    println(m.findMedian());
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */