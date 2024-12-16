package com.designguru.code.pattern.prefixsum;

public class FindTheMiddleIndexOfArray {

    public static int findMiddleIndex(int[] nums) {

      int sum = 0;

      for ( int n : nums ) {
          sum += n;
      }

      int leftSum = 0;

      for ( int i = 0; i < nums.length; ++i ) {
          int rightSum = sum - leftSum;
          leftSum += nums[i];
          if ( rightSum == leftSum ) {
              return i;
          }
      }

      return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{ 1, 7, 3, 6, 5, 6 }));
        System.out.println(findMiddleIndex(new int[]{ 2, 1, -1 }));
        System.out.println(findMiddleIndex(new int[]{ 2, 3, 5, 5, 3, 2 }));
    }
}
