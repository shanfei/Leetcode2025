package com.designguru.code.pattern.heap.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * Given an array of numbers nums and an integer K,
 * find the maximum number of distinct elements after removing exactly K elements from the nums array.
 *
 * Example 1:
 *
 * Input: nums = [7, 3, 5, 8, 5, 3, 3], K=2
 * Expected Output: 3
 * Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8],
 * we have to skip 5 because it is not distinct and occurred twice.
 * Another solution could be to remove one instance of '5' and '3' each to be left with three distinct numbers [7, 5, 8],
 * in this case, we have to skip 3 because it occurred twice.
 *
 * Example 2:
 *
 * Input: [3, 5, 12, 11, 12], and K=3
 * Expected Output: 2
 * Explanation: We can remove one occurrence of 12, after which all numbers will become distinct.
 * Then we can delete any two numbers which will leave us 2 distinct numbers in the result.
 *
 * Example 3:
 *
 * Input: [1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5], and K=2
 * Expected Output: 3
 * Explanation: We can remove one occurrence of '4' to get three distinct numbers 1, 2 and 4.
 *
 */
public class MaxDistinctElement {


    public int findMaximumDistinctElements(int[] nums, int k) {
        int distinctElementsCount = 0;

        PriorityQueue<NumWithFrequency> pq = new PriorityQueue<>( (a, b ) -> a.frequency - b.frequency );
        Map<Integer, NumWithFrequency> map = new HashMap<>();

        for (int num : nums) {
            NumWithFrequency numWithFrequency = map.getOrDefault( num , new NumWithFrequency(num, 0));
            numWithFrequency.frequency++;
            map.put(num, numWithFrequency);
        }

        // 把重复元素加入 优先级队列
        for  (NumWithFrequency n : map.values()) {
            if ( n.frequency > 1 ) {
                pq.offer( n );
            } else {
                distinctElementsCount++;
            }
        }

        // 从优先级队列里面 移除最多重复次数的元素
        while ( !pq.isEmpty() && k > 0 ) {
            NumWithFrequency n = pq.poll();
            int m = n.frequency - 1;
            k -= m;
            if ( k >= 0 ) {
                distinctElementsCount++;
            }
        }

        // 移除剩下的 distinct 元素
        if ( k > 0 ) {
            distinctElementsCount -= k;
        }


        return distinctElementsCount;

    }
}

class NumWithFrequency {
    public int num;
    public int frequency;

    public NumWithFrequency(int num, int frequency) {
        this.num = num;
        this.frequency = frequency;
    }
}
