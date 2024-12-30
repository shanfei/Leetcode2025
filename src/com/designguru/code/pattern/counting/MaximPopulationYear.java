package com.designguru.code.pattern.counting;

/**
 *
 * You are given a 2D integer array logs containing the birth and death years of n people.
 * In logs array, logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
 *
 * The population of a year is the number of people alive during that year.
 * The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1].
 *
 * Return the earliest year with the highest population.
 *
 * Examples
 * Example 1:
 *
 * Input: logs = [[1980, 1990], [1975, 1985], [1985, 1995], [1990, 2000], [1999, 2020], [1994, 2032]]
 * Expected Output: 1994
 * Explanation: The population in the year 1994 was the highest. In that year, 3 people were alive (born in 1985, 1990, and 1994).
 * Example 2:
 *
 * Input: logs = [[1970, 1990], [1980, 2009], [1960, 1970], [1959, 1982]]
 * Expected Output: 1980
 * Explanation: The population in the year 1980 was the highest. In that year, three people were alive (born in 1970, 1980, and 1959).
 * Example 3:
 *
 * Input: logs = [[2000, 2010], [2005, 2015], [2010, 2020], [2015, 2025]]
 * Expected Output: 2005
 * Explanation: The population in the year 2005 was the highest. In that year, two people were alive (born in 2000, and 2005).
 *
 */
public class MaximPopulationYear {

    public static int maximumPopulation(int[][] logs) {

        int count = 1;
        int maxCount = 0;

        for ( int i = 0; i < logs.length; ++i ) {

            if ( logs[i + 1][0] < logs[i][1] ) {
                count++;
                logs[i + 1][0] = Math.max(logs[i][0], logs[i + 1][0]);
                logs[i + 1][1] = Math.min(logs[i][0], logs[i + 1][0]);
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
