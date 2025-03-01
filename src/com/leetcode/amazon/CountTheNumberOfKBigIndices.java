package com.leetcode.amazon;

/**
 *
 * leetcode 2519:
 *
 * You are given a 0-indexed integer array nums and a positive integer k.
 *
 * We call an index i k-big if the following conditions are satisfied:
 *
 * There exist at least k different indices idx1 such that idx1 < i and nums[idx1] < nums[i].
 * There exist at least k different indices idx2 such that idx2 > i and nums[idx2] < nums[i].
 * Return the number of k-big indices.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,6,5,2,3], k = 2
 * Output: 2
 * Explanation: There are only two 2-big indices in nums:
 * - i = 2 --> There are two valid idx1: 0 and 1. There are three valid idx2: 2, 3, and 4.
 * - i = 3 --> There are two valid idx1: 0 and 1. There are two valid idx2: 3 and 4.
 * Example 2:
 *
 * Input: nums = [1,1,1], k = 3
 * Output: 0
 * Explanation: There are no 3-big indices in nums.
 *
 *
 *
 * using PQ nLogN
 *
 * from the left to right to computer the KthLargestElement
 * if validFromLeft && validFromRight then add to validIndex count++
 *
 * n = ( totalCount - k * 2 ) / 2  ;
 *
 * hleft = (0 .. k)
 * hright = ( n .. k)
 *
 * vl[] = false
 * vr[] = false
 * for ( i,j if ( i <= j ) -> {
 *
 *     if ( hleft.peek()  <= a[i] ) {
 *         vl[i] = true;
 *
 *     }
 *
 *     if ( hRight.peek() <= a[j] ) {
 *         vr[j] = true;
 *     }
 *
 *     addToHLeftAndMaintain(a[i],size == k);
 *     addToHRightAndMaintain(a[j],size == k);
 *
 *     i++;
 *     j--;
 * })
 *
 * for ( i <- 0 ... totalCount - k ) {
 *     if (vl[i] && vr[i] ) {
 *         count++;
 *     }
 * }
 *
 * TODO: implement me
 */
public class CountTheNumberOfKBigIndices {

    public int kBigIndices(int[] nums, int k) {
        return -1;
    }
}
