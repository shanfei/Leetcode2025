package com.designguru.code.pattern.simulation;

/**
 *
 * There are numBottles number of bottles filled with water.
 * You can trade a numExchange number of empty bottles and get a single filled water bottle.
 *
 * When you drink a bottle, it becomes empty.
 *
 * Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
 *
 * Examples
 * Example 1
 * Input: numBottles = 15, numExchange = 4
 * Expected Output: 19
 * Explanation:
 * You start with 15 full bottles.
 * Drink 15 bottles (now 15 empty).
 * Exchange 12 empty bottles for 3 full (now 3 full, 3 empty).
 * Drink 3 more (now 6 empty).
 * Exchange 4 empty for 1 full (now 1 full, 2 empty).
 * Drink 1 more (now 3 empty).
 * You can't get 1 full bottle using 3 empty bottles.
 * You can drink 15 + 3 + 1 = 19 bottoles.
 * Example 2
 * Input: numBottles = 7, numExchange = 3
 * Expected Output: 10
 * Explanation:
 * Start with 7 full bottles.
 * Drink 7 bottles (7 empty).
 * Exchange 6 empty for 2 full (now 2 full, 1 empty).
 * Drink 2 more (3 empty).
 * Exchange 3 empty for 1 full (now 1 full, 0 empty).
 * Drink 1 more (total = 7 + 2 + 1 = 10).
 * Example 3
 * Input: numBottles = 5, numExchange = 5
 * Expected Output: 6
 * Explanation:
 * Start with 5 full bottles.
 * Drink 5 bottles (5 empty).
 * Exchange 5 empty for 1 full (now 1 full, 0 empty).
 * Drink 1 more (total = 5 + 1 = 6).
 *
 */
public class WaterBottles {

    public int getMaxBottles(int numBottles, int numExchange) {
        // ToDo: Write Your Code Here.
        return 0;
    }

}
