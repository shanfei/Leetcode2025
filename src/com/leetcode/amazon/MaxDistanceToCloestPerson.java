package com.leetcode.amazon;

/**
 *
 * You are given a binary array seats representing the row of seats,
 * where seats[i] = 0 represents that the ith seat is empty, and seats[i] = 1 represents a person sitting in the ith seat.
 * It is given that seats array contains at least one 1 and 0.
 *
 * You want to sit in any seat such that the distance between you and the closest person to you is maximized.
 *
 * Return that maximum distance to the closest person.
 *
 * Examples
 *
 * Example 1:
 *
 * Input: seats = [1,0,0,0,1,0,0]
 * Expected Output: 2
 * Justification: The best seat is either of the two at the index 2 or 6, as they are both 2 seats away from the nearest occupied seat.
 *
 * Example 2:
 *
 * Input: seats = [1,0,0,0,0,1]
 * Expected Output: 2
 * Justification: The middle seats (index 2 or 3) are equally optimal, being 2 seats away from any occupied seat.
 *
 * Example 3:
 *
 * Input: seats = [0,1,0,1,0,1,0,0,0,0]
 * Expected Output: 4
 * Justification: The best position is at the end (index 9), which is 4 seats away from the nearest person.
 *
 *
 */
public class MaxDistanceToCloestPerson {

    public int maxDistToClosest(int[] seats) {

        int d = seats.length;

        int prevOccupied = -1;

        int m = Integer.MIN_VALUE;

        for ( int i = 0; i < d; ++i ) {

            if ( seats[i] == 0 ) continue;

            m = prevOccupied == -1 ? i : Math.max(m, (i - prevOccupied) / 2);

            prevOccupied = i;
        }


        m = Math.max( d - prevOccupied - 1 , m);


        return m;
    }
}
