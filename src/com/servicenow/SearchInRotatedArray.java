package com.servicenow;

/**
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * TODO: redo using pivot and binary search
 *
 */
public class SearchInRotatedArray {

    public int search(int[] nums, int target) {

       return searchInUnsorted(nums, 0, nums.length - 1, target);
    }

    int searchInUnsorted(int[] nums, int s, int e, int target) {

           if (nums[s] <= nums[e]) {
               return searchInSorted(nums, s, e, target);
           }

            int m = ( s + e ) / 2;

            int k = nums[m];

            if ( k == target) {
                return m;
            }

            if ( nums[s] <= k ) {
                // 1st part sorted
               if ( k > target && nums[s] <= target ) {
                   return searchInSorted(nums, s, m, target);
               } else {
                   return searchInUnsorted(nums, m + 1, e, target);
               }

            } else if ( nums[e] >= k ) {
                // 2nd part sorted
                if ( k < target && nums[e] >= target ) {
                    return searchInSorted(nums, m, e, target);
                } else {
                    return searchInUnsorted(nums, s, m - 1, target);
                }
            } else {
                int a = searchInUnsorted(nums, s, m - 1, target);
                if ( a == -1 ) {
                    return searchInUnsorted(nums, m + 1, e, target);
                } else {
                    return a;
                }
            }
    }

    int searchInSorted(int[] nums, int s, int e, int target) {

        while ( s <= e ) {

            int m = ( s + e ) / 2;

            int k = nums[m];

            if ( k == target ) {
                return m;
            } else if ( k > target ) {
                e = m - 1;
            } else {
                s = m + 1;
            }

        }

        return -1;
    }


    public static void main(String[] args) {

        SearchInRotatedArray instance = new SearchInRotatedArray();

        System.out.println(instance.search(new int[]{ 1,2,3 }, 3));
        System.out.println(instance.search(new int[]{ 1,2,3 }, 2));
        System.out.println(instance.search(new int[]{ 1,2,3 }, 1));
        System.out.println(instance.search(new int[]{ 3,2,1 }, 1));
        System.out.println(instance.search(new int[]{ 3,2,1 }, 3));
        System.out.println(instance.search(new int[]{ 3,2,1 }, 2));
        System.out.println(instance.search(new int[]{4,5,6,7,8,1,2,3}, 8));
        System.out.println(instance.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(instance.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(instance.search(new int[]{ 5,1,3 }, 3));



    }

}
