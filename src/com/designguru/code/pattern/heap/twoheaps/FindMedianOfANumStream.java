package com.designguru.code.pattern.heap.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * Design a class to calculate the median of a number stream. The class should have the following two methods:
 *
 * insertNum(int num): stores the number in the class
 * findMedian(): returns the median of all numbers inserted in the class
 * If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
 *
 * Example 1:
 *
 * 1. insertNum(3)
 * 2. insertNum(1)
 * 3. findMedian() -> output: 2
 * 4. insertNum(5)
 * 5. findMedian() -> output: 3
 * 6. insertNum(4)
 * 7. findMedian() -> output: 3.5
 *
 */
public class FindMedianOfANumStream {


}


class Solution {

    // min heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    // max heap
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public Solution()
    {

    }

    // 这题 的关键 是保持 最大堆 和 最小堆 局部有序，就是 最大堆的最大元素 必须小于 最小堆的最小元素 才行
    // insert 操作的时间复杂度 是O(n)
    public void insertNum(int num) {

        if ( maxHeap.isEmpty() || num <= maxHeap.peek() ) {
            maxHeap.offer(num);
        } else {
            // 这就是为什么需要这一步, 一直保持 最小堆的堆顶元素 大于 num， 而最大堆的堆顶元素 小于 num
            while ( !minHeap.isEmpty() && num > minHeap.peek() ) {
                maxHeap.offer(minHeap.poll());
            }
            minHeap.offer(num);
        }

        // 平衡 最大 最小堆
        while ( maxHeap.size() > minHeap.size() + 1 ) {
            minHeap.offer(maxHeap.poll());
        }

        // 平衡 最大 最小堆
        while ( minHeap.size() > maxHeap.size() + 1 ) {
            maxHeap.offer(minHeap.poll());
        }

    }

    // 取中位数 的时间复杂度 是O(1)
    public  double findMedian() {

        int min = minHeap.isEmpty() ? 0 : minHeap.peek();
        int max = maxHeap.isEmpty() ? 0 : maxHeap.peek();

        if ( maxHeap.size() != minHeap.size() ) {
            return maxHeap.size() > minHeap.size() ? max : min;
        }

        return (double) ( min + max ) / 2;
    }
}
