package com.designguru.code.pattern.dp.knapsack;

public class SubsetSum {

    public boolean canPartition(int[] num, int sum) {
        return canPartitionRecursive(num, 0, sum, 0, new Boolean[num.length][sum + 1]);
    }

    boolean canPartitionRecursive(int[] num, int currentIndex, int sum, int currentSum, Boolean[][] cache) {
        if (currentIndex >= num.length) {
            return false;
        }

        int s = currentSum + num[currentIndex];

        if (s > sum) {
            return false;
        }

        if (cache[currentIndex][s] != null) {
            return cache[currentIndex][s];
        }

        if (s == sum) {
            return true;
        }

        boolean withCurrentNum = canPartitionRecursive(num, currentIndex + 1, sum, s, cache);
        boolean withoutCurrentNum = canPartitionRecursive(num, currentIndex + 1, sum, currentSum, cache);

        cache[currentIndex][s] = withCurrentNum || withoutCurrentNum;
        return cache[currentIndex][s];
    }
}
