package com.designguru.code.pattern.stack.monotonic;

import java.util.Stack;

/**
 *
 * Given an array of integers temperatures representing daily temperatures,
 * your task is to calculate how many days you have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 *
 * Examples
 *
 * Input: temperatures = [70, 73, 75, 71, 69, 72, 76, 73]
 * Output: [1, 1, 4, 2, 1, 1, 0, 0]
 * Explanation: The first day's temperature is 70 and the next day's temperature is 73 which is warmer. So for the first day, you only have to wait for 1 day to get a warmer temperature. Hence, the first element in the result array is 1. The same process is followed for the rest of the days.
 * Input: temperatures = [73, 72, 71, 70]
 * Output: [0, 0, 0, 0]
 * Explanation: As we can see, the temperature is decreasing every day. So, there is no future day with a warmer temperature. Hence, all the elements in the result array are 0.
 * Input: temperatures = [70, 71, 72, 73]
 * Output: [1, 1, 1, 0]
 * Explanation: For the first three days, the next day is warmer. But for the last day, there is no future day with a warmer temperature. Hence, the result array is [1, 1, 1, 0].
 *
 *
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            int t = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] < t) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }

            stack.push(i);
        }


        return res;
    }
}
