package com.servicenow;


/**
 *
 *
 * Leetcode: 42
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 *
 * [ 1,0,2 ] -> 1
 * [ 2,1,0,1,3 ] -> 1 + 2 + 1 => 4
 * [ 3, 2, 1, 2 ] ->  1
 *  1 + 4 + 1 => 6
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 *
 * Input: height = [ 5,2,0,3,2,1 ]
 * Output: 9
 *
 * [ 4, 2, 0, 6, 4, 7, 5 ] -> min : 4 => 2 + 4 + 1 + 2 => 9
 *
 * left : 4 , right : 5 -> RM -> 5 ans : 0
 * left : 4 , right : 2 -> RM -> 5, LM -> 4  ans : 2
 * left : 2 , right : 2 -> LM -> 4, RM -> 5  ans : 4
 * left : 2,  right : 3
 *
 *
 * 1. stack
 * 2. 2 pointer
 *
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int l = 0, r = height.length - 1;

        int ans = 0;
        int maxL = 0, maxR = 0;

        while ( l < r ) {

            int lv = height[l];
            int rv = height[r];

            maxL = Math.max(maxL, lv);
            maxR = Math.max(maxR, rv);

            if ( lv < rv ) {
                ans += maxL - lv;
                l++;
            } else {
                ans += maxR - rv;
                r--;
            }
        }

        return ans;


    }

    public static void main(String[] args) {
        TrappingRainWater instance = new TrappingRainWater();

        int[] a = { 0,1,0,2,1,0,1,3,2,1,2,1 };

        System.out.println(instance.trap(a));

        a = new int[] { 4,2,0,3,2,5 };

        System.out.println(instance.trap(a));
    }



}
