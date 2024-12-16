package com.amazon;

/**
 *
 * Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.
 *
 * solution using recursive with cache
 *
 * Example 1:
 *
 * Input: data = [1,0,1,0,1]
 * Output: 1
 * Explanation: There are 3 ways to group all 1's together:
 * [1,1,1,0,0] using 1 swap.
 * [0,1,1,1,0] using 2 swaps.
 * [0,0,1,1,1] using 1 swap.
 * The minimum is 1.
 * Example 2:
 *
 * Input: data = [0,0,0,1,0]
 * Output: 0
 * Explanation: Since there is only one 1 in the array, no swaps are needed.
 * Example 3:
 *
 * 1. count all the 1
 * 2. slide window find the max count of 1 in the window size of count of 1
 * 3. return count of 1 -  max count of 1 in the slide window
 *
 * Input: data = [1,0,1,0,1,0,0,1,1,0,1]
 * Output: 3
 * Explanation: One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
 *
 */

public class MinSwapToGroupAllOnesTogether {

    public int minSwaps(int[] data) {


        int windowSize = 0;

        for ( int n : data ) {
            windowSize += n;
        }

        int maxCount = 0;
        int count = 0;

        for ( int i = 0, j = 0; j < data.length; ) {

            if ( j - i == windowSize ) {

                maxCount = Math.max( maxCount , count);

                count -= data[i++];

                continue;
            }

            count += data[j++];

            maxCount = Math.max( maxCount , count);
        }

        return maxCount == 1 ? 0 : windowSize - maxCount;

    }

    public static void main(String[] args) {
        MinSwapToGroupAllOnesTogether instance = new MinSwapToGroupAllOnesTogether();

        System.out.println(instance.minSwaps(new int[]{ 1,0,0,1,1,1 }));
    }
}
