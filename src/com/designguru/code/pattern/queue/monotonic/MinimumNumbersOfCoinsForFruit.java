package com.designguru.code.pattern.queue.monotonic;

import java.util.*;

/**
 *
 * You are given an array of integers prices where each element prices[i] represents the number of coins required to buy the ith fruit.
 *
 * The fruit market has the following reward for each fruit:
 *
 * If you buy the ith fruit for prices[i] coins, you can get the next (i + 1) fruits for free.
 * Note: Even if you have the option to take certain fruits for free, you can still choose to purchase them at their respective prices[j] to gain the reward for the next fruits.
 *
 * Return the minimum number of coins needed to get all the fruits.
 *
 * Example 1:
 * Input: prices = [1, 6, 1, 2, 4]
 * Expected Output: 2
 * Explanation:
 * Purchase the first fruit for 1 coin. Get next i + 1 = 0 + 1 = 1 fruit for free.
 * Get a second fruit for free.
 * Purchase the third fruit for 1 coin, and get next i + 1 = 2 + 1 = 3 fruits for free.
 * Get fourth and fifth fruit for free.
 * Total cost = 1 + 1 = 2.
 *
 * Example 2:
 * Input: prices = [2, 3, 5, 1]
 * Expected Output: 5
 * Explanation:
 * Purchase the first fruit for 2 coins. This allows you to take the second fruit for free.
 * You get 2nd fruit for free, but still, purchase it with 3 coins to get the third and fourth fruit for free.
 * So, total cost = 2 + 3 = 5.
 *
 * Example 3:
 * Input: prices = [3, 2, 1, 4]
 * Expected Output: 4
 * Explanation:
 * Purchase the first fruit for 3 coins. Get next i + 1 = 0 + 1 = 1 fruit for free.
 * Get a second fruit for free.
 * Purchase the third fruit for 1 coin, and get next i + 1 = 2 + 1 = 3 fruits for free.
 * Get fourth fruit for free.
 * Total cost = 3 + 1 = 4.
 *
 * 从数组的尾到头 按照题目规则 要 拿到第 i 个水果 的 范围 是  k = Math.floor (（ i - 1 ）/ 2 )
 * 所以 在 范围 j 属于 [ k, i ) 里面 获取一个最小代价 min a[j]
 * 同样 循环反推到 j = 0
 *
 * O(N)
 *
 * 动态规划 + 单调队列，单调队列存的是 从小到大的 price 数组的index 更新prices[i] 的值
 * price[i] = Math.min(deque.header + price[i]); 当前 index 可以走到的范围里面最小的一个价格
 */
public class MinimumNumbersOfCoinsForFruit {

    public static int minimumCoins(int[] prices) {

        int n = prices.length;
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(n);
        prices = Arrays.copyOf(prices, n + 1);
        prices[n] = 0;

        for ( int j = n - 1; j >= 0; --j ) {

            int maxCoveredIndex = Math.min(n, j * 2 + 2 );

            // 一旦 可以 cover的 index 变小了 就要更新队列的范围，
            while ( !deque.isEmpty() && deque.peekFirst() > maxCoveredIndex ) {
                deque.pollFirst();
            }

            // 当前的 price 一定是 这个index可以conver的index里面加个最小的 那个 也就是队列头部的index
            prices[j] += prices[deque.peekFirst()];

            // 保持队列里面的元素是单调递增的
            while ( !deque.isEmpty() && prices[j] < prices[deque.peekLast()] ) {
                deque.pollLast();
            }

            deque.offerLast(j);

        }


        return prices[0];
    }

    public static void main(String[] args) {

        List<int[]> as = List.of(
            new int[]{1, 6, 1, 2, 4},
            new int[]{2, 3, 5, 1},
            new int[]{3, 2, 1, 4}
        );


        for (int[] a : as) {
           System.out.println(minimumCoins(a));
        }
    }
}
