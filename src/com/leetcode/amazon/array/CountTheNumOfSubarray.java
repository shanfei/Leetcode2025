package com.leetcode.amazon.array;

import kotlin.Pair;

import java.util.*;

/**
 *
 *
 * Given an array of integers nums, and an integer k, find the count of "good" subarrays within nums.
 *
 * A subarray is considered "good" if it contains at least k pairs of elements (i, j) where i < j and nums[i] == nums[j].
 *
 * A subarray is a contiguous sequence of elements in the original array.
 *
 * Examples
 *
 * Example 1:
 *
 * Input: nums = [2, 2, 2, 3, 3], k = 3
 * Expected Output: 3
 * Justification: There are 3 good subarrays that meet the criteria: [2, 2, 2, 3], [2, 2, 2, 3, 3], and [2, 2, 2].
 * Each of these subarrays has at least 3 pairs of equal elements.
 *
 * Example 2:
 *
 * Input: nums = [4, 4, 4, 4], k = 6
 * Expected Output: 1
 * Justification: The only good subarray that meets the criteria is the entire array itself [4, 4, 4, 4],
 * which contains 6 pairs of equal elements.
 *
 * Example 3:
 *
 * Input: nums = [1, 2, 3, 1, 2], k = 2
 * Expected Output: 2
 * Justification: There is only 1 good subarray, which is [1, 2, 3, 1, 2]. It contains at least 2 pairs of equal elements.
 *
 *
 */

class RangeWithId {

    public int id;
    public int start;
    public int end;

    public RangeWithId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RangeWithId that = (RangeWithId) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

public class CountTheNumOfSubarray {

    // Method to count the number of good subarrays
    public static int countGood(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, RangeWithId> ridMap = new HashMap<>();
        PriorityQueue<RangeWithId> pq = new PriorityQueue<>( (a, b) -> {
            return a.start - b.start;
        });

        for ( int i = 0; i < nums.length; ++i ) {

            int n = nums[i];

            int count = map.getOrDefault(n, 0);

            map.put( n, map.getOrDefault(n, 0) + 1);

            if ( count > 0 ) {
                RangeWithId rid = ridMap.get(n);
                rid.end = i;
            } else {
                RangeWithId rid = new RangeWithId(n);
                rid.start = i;
                ridMap.put(n, rid);
            }

        }

        pq.addAll(ridMap.values());

        Map<Integer, Integer> pairCounts = new HashMap<>();

        int c = 0;

        for ( Map.Entry<Integer, Integer> e : map.entrySet() ) {

            int key = e.getKey();
            int count = e.getValue();

            int pairCnt = ( count * ( count - 1 ) ) / 2;
            pairCounts.put(key, pairCnt);

        }

        if (pq.isEmpty()) {
            return 0;
        }

        // TODO: O(n)
        for ( int i = 0; i < pq.size() - 1; ++i ) {

            RangeWithId r1 = pq.poll();
            RangeWithId r2 = pq.poll();

            if ( r1.end > r2.start ) {
                c += pairCounts.get(r2.id);
            } else {
                if ( pairCounts.get(r1.id) >= k ) {
                    c += nums.length - ridMap.get(r1.id).end;
                } else if (  c + pairCounts.get(r1.id) >= k ) {
                    c += nums.length - ridMap.get(r1.id).end;
                }
            }
        }

        return c;
    }


    public static void main(String[] args) {
        System.out.println(countGood(new int[] {2,2,2,3,3}, 3));
        System.out.println(countGood(new int[] {4, 4, 4, 4}, 6));
        System.out.println(countGood(new int[] {1, 2, 3, 1, 2}, 2));


    }
}
