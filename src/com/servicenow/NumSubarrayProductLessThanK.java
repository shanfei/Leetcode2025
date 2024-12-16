package com.servicenow;


/**
 *
 * Leetcode 713
 *
 *  Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 *
 * Slide window
 *
 * tip: continous subarray using slide window
 *
 *
 */
public class NumSubarrayProductLessThanK {


    public  int numSubarrayProductLessThanK(int[] nums, int k) {

        int p = 1;

        int c = 0;

        for ( int l = 0, r = 0;  l <= r && r < nums.length; ) {

            p *= nums[r++];

            while (  l < r && p >= k ) {
                p /= nums[l++];
            }

            c += r - l;
        }


        return c;

    }



    public static void main(String[] args) {
        NumSubarrayProductLessThanK instance = new NumSubarrayProductLessThanK();

        //nums = [10,5,2,6], k = 100 n = 8
        //nums = [1,2,3], k = 0 n = 8
        int[] nums = { 1,2,3 };
        int k = 4;

        System.out.println(instance.numSubarrayProductLessThanK(nums, k));



    }
}
