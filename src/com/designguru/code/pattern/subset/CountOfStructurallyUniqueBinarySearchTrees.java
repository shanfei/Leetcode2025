package com.designguru.code.pattern.subset;

/**
 *
 * Given a number ‘n’, write a function to return the count of structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: As we saw in the previous problem, there are 2 unique BSTs storing numbers from 1-2.
 * Example 2:
 *
 * Input: 3
 * Output: 5
 * Explanation: There will be 5 unique BSTs that can store numbers from 1 to 3.
 *
 */
public class CountOfStructurallyUniqueBinarySearchTrees {


    public int countTrees(int n) {
        return countTree(1,n);
    }

    int countTree(int s, int e) {

        if (s > e) {
            return 1;
        }

        int t = 0;

        for ( int i = s; i <= e; i++ ) {

            int lc = countTree(s, i - 1);
            int rc = countTree(i + 1, e);

            t += lc * rc;

        }

        return t;
    }
}
