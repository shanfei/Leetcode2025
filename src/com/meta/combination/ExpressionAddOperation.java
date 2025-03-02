package com.meta.combination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 *
 */

public class ExpressionAddOperation {

    static final char[] ops = { '*','+','-' };

    public List<String> addOperators(String num, int target) {

        int[] nums = new int[num.length()];

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = (num.charAt(i) - '0');
        }

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);

        matchTarget(nums, 1, target, nums[0], new HashMap<>(), sb, result);

        return result;

    }

    void matchTarget( int[] nums, int i, int target, int r, Map<String, Integer> cache, StringBuilder sb, List<String> result ) {

        if ( target == r && nums.length == i ) {
            result.add(sb.toString());
        }

        if ( i > nums.length - 1) {
            return;
        }

        int n = nums[i];

        //TODO: if (*) , re-op prev if prev op is not * , then nums[i-1] * nums[i] , apply prev op with this tmp r

        for ( char op : ops ) {

            sb.append(op);
            sb.append(n);

            if ( op == '*' ) {

//                int nextN = nums[i + 1];
//                int nextR =
//                String key = sb.toString();
//
//                int nextR = cache.getOrDefault(key, calculate(n, op, r));
//                cache.putIfAbsent(key, nextR);

                matchTarget(nums, i + 2, target, r, cache, sb, result);

                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);

            } else {

            }








        }
    }

    int calculate(int n, char op, int r) {
        switch (op) {
            case '-':
                return r - n;
            case '+':
                return r + n;
            case '*':
                return r * n;
        }

        return -1;
    }

    public static void main(String[] args) {
        ExpressionAddOperation a = new ExpressionAddOperation();
        System.out.println(a.addOperators("123",6));
    }

}
