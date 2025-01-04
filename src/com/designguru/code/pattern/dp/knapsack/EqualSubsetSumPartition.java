package com.designguru.code.pattern.dp.knapsack;

/**
 *
 * Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 *
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 * Example 2:
 *
 * Input: {1, 1, 3, 4, 7}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
 * Example 3:
 *
 * Input: {2, 3, 4, 6}
 * Output: False
 * Explanation: The given set cannot be partitioned into two subsets with equal sum.
 *
 */
public class EqualSubsetSumPartition {

    public boolean canPartition(int[] num) {
        int totalSum = 0;
        for (int n : num) {
            totalSum += n;
        }
        Boolean[][] cache = new Boolean[num.length][totalSum + 1];
        return canPartitionRecursive(num, 0, cache, 0, totalSum);
    }

    private boolean canPartitionRecursive(int[] num, int currentIndex, Boolean[][] cache, int currentSum, int totalSum) {
        if (currentIndex >= num.length) {
            return false;
        }

        if (cache[currentIndex][currentSum] != null) {
            return cache[currentIndex][currentSum];
        }

        if (currentSum == totalSum - currentSum) {
            return true;
        }

        boolean withCurrentNum = canPartitionRecursive(num, currentIndex + 1, cache, currentSum + num[currentIndex], totalSum);
        boolean withoutCurrentNum = canPartitionRecursive(num, currentIndex + 1, cache, currentSum, totalSum);

        cache[currentIndex][currentSum] = withCurrentNum || withoutCurrentNum;

        return cache[currentIndex][currentSum];
    }

}
