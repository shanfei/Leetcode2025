package com.designguru.code.pattern.dp.knapsack;

/**
 *
 * Given two integer arrays to represent weights and profits of ‘N’ items, find a subset of these items that will give us maximum profit such that their cumulative weight is not more than a given number ‘C’, and return the maxium profit. Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
 *
 * Let’s take Merry’s example, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:
 *
 * Items: { Apple, Orange, Banana, Melon }
 *
 * Weights: { 2, 3, 1, 4 }
 *
 * Profits: { 4, 5, 3, 7 }
 *
 * Knapsack capacity: 5
 *
 * Let’s try to put various combinations of fruits in the knapsack, such that their total weight is not more than 5:
 *
 * Apple + Orange (total weight 5) => 9 profit
 *
 * Apple + Banana (total weight 3) => 7 profit
 *
 * Orange + Banana (total weight 4) => 8 profit
 *
 * Banana + Melon (total weight 5) => 10 profit
 *
 * This shows that Banana + Melon is the best combination as it gives us the maximum profit, and the total weight does not exceed the capacity.
 *
 */
public class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int maxProfit = 0;
        int[][] currentWeightAndCapacity = new int[profits.length][capacity + 1];

        maxProfit = solveKnapsackRecursive(profits, weights, capacity, 0,  currentWeightAndCapacity);

        return maxProfit;
    }

    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex,
                                      int[][] profitCache) {


        if ( capacity <= 0 || currentIndex >= profits.length ) {
            return 0;
        }

        int p = profits[currentIndex];
        int w = weights[currentIndex];

        if (profitCache[currentIndex][capacity] != 0 ) {
            return profitCache[currentIndex][capacity];
        }


        int profitWithCurrentItem = w <= capacity ? p + solveKnapsackRecursive(profits, weights, capacity - w, currentIndex + 1, profitCache) : 0;
        int profitWithoutCurrentItem = solveKnapsackRecursive(profits, weights, capacity, currentIndex + 1, profitCache);

        int maxProfit = Math.max(profitWithCurrentItem, profitWithoutCurrentItem);

        profitCache[currentIndex][w] = maxProfit;
        return maxProfit;
    }

}
