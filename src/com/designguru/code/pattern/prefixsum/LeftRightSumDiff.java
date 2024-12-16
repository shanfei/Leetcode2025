package com.designguru.code.pattern.prefixsum;

public class LeftRightSumDiff {

    public static int[] findDifferenceArray(int[] nums) {

        int n = nums.length;
        int[] differenceArray = new int[n];

        int sum = 0;

        for ( int i : nums ) {
            sum += i;
        }

        int leftSum = 0;
        int rightSum = sum;

        for ( int i = 0; i < n; ++i ) {
            rightSum -= nums[i];
            differenceArray[i] = Math.abs(rightSum - leftSum);
            leftSum += nums[i];
        }

        return differenceArray;
    }

    public static void main(String[] args) {

        int[][] inputs = {{ 2, 5, 1, 6, 1 }, {3, 3, 3}, {1, 2, 3, 4, 5}};

        for ( int[] input : inputs ) {
            int[] r = LeftRightSumDiff.findDifferenceArray(input);

            for (int n : r) {
                System.out.print(n + ",");
            }
            System.out.println();
        }
    }

}
