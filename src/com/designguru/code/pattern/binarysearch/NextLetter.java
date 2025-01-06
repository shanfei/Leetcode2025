package com.designguru.code.pattern.binarysearch;

/**
 *
 * Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given ‘key’.
 *
 * Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter. This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.
 *
 * Write a function to return the next letter of the given ‘key’.
 *
 * Example 1:
 *
 * Input: ['a', 'c', 'f', 'h'], key = 'f'
 * Output: 'h'
 * Explanation: The smallest letter greater than 'f' is 'h' in the given array.
 * Example 2:
 *
 * Input: ['a', 'c', 'f', 'h'], key = 'b'
 * Output: 'c'
 * Explanation: The smallest letter greater than 'b' is 'c'.
 * Example 3:
 *
 * Input: ['a', 'c', 'f', 'h'], key = 'm'
 * Output: 'a'
 * Explanation: As the array is assumed to be circular, the smallest letter greater than 'm' is 'a'.
 * Example 4:
 *
 * Input: ['a', 'c', 'f', 'h'], key = 'h'
 * Output: 'a'
 * Explanation: As the array is assumed to be circular, the smallest letter greater than 'h' is 'a'.
 *
 */
public class NextLetter {

    public char searchNextLetter(char[] letters, char key) {
        if (key > letters[letters.length - 1]) {
            return letters[0];
        }

        int s = 0, e = letters.length - 1;

        while ( s <= e ) {

            int mid = s + (e - s) / 2;
            int midVal = letters[mid];

            if ( key == midVal ) {
                int v = mid == letters.length - 1 ? 0 : mid + 1;
                return letters[v];
            } else if ( key > midVal ) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return e == letters.length - 1 ? letters[0] : letters[e + 1];
    }

}
