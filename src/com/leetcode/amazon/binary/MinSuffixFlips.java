package com.leetcode.amazon.binary;

/**
 *
 *
 * Initialize a variable flips to 0. This will keep track of the number of flips required to make the string uniform.
 * Initialize a variable prev to '0' to represent the initial expected character in the string,
 * considering the string initially contains all '0's.
 * Iterate through each character in the target string using a for loop. In each iteration, compare the current character with prev:
 *
 * If the current character is different from prev, this indicates a transition point where a flip is needed.
 * Increment the flips counter by 1 to account for this flip.
 * Update prev to the current character, as this character is now the last flipped state in our operation.
 * After completing the iteration through the string,
 * return the flips counter as the total number of flips required to make the string uniform.
 *
 *
 *
 */
public class MinSuffixFlips {

    public int minFlips(String target) {

        int flips = 0; // Initialize flips counter

        char[] t = target.toCharArray();

        char prv = '0';

        for ( int i = 0; i < t.length; ++i ) {

            char c = t[i];

            if ( c != prv ) {
                flips++;
                prv = c;
            }

        }


        return flips; // Return the total flips required
    }

}
