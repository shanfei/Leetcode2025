package com.designguru.code.pattern.fastslowpointers;


/**
 *
 * We are given an array containing positive and negative numbers.
 * Suppose the array contains a number ‘M’ at a particular index.
 * Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
 * You should assume that the array is circular which means two things:
 *
 * If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
 * If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
 *
 * Write a method to determine if the array has a cycle.
 * The cycle should have more than one element and should follow one direction which means the cycle should not contain both forward and backward movements.
 *
 */
public class CycleInACircularArray {

    public boolean loopExists(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int slow = i, fast = i;

            do {

                slow = move(arr, slow);
                fast = move(arr, fast);

                if (slow == -1 || fast == -1) {
                    break;
                }

                fast = move(arr, fast);
                if (fast == -1) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }

            } while (true);

        }

        return false;

    }

    int move(int[] arr, int i) {

        int steps = arr[i];

        int nextIndex = steps > 0 ? (i + steps) % arr.length : (i + steps + arr.length) % arr.length;
        int nextSteps = arr[nextIndex];

        if ( nextSteps * steps > 0 && nextIndex != i) {
            return nextIndex;
        } else {
            return -1;
        }
    }
}
