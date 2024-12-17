package com.servicenow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Leetcode 6:
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 */

public class ZigZagConversion {

    public String convert(String s, int numRows) {

        boolean isDown = true;
        int x = 0, y = 0;

        if (numRows == 1) {
            return s;
        }
        
        TreeMap<Integer, Character> m = new TreeMap<>();

        int n = s.length();
        int sections = (int) Math.ceil(n / (2 * numRows - 2.0));
        int numberOfColumns = sections * (numRows - 1);

        for (int i = 0; i < s.length(); ++i) {

            m.put(x + y * numberOfColumns, s.charAt(i));

            if (isDown) {
                y++;
            } else {
                y--;
                x++;
            }

            if ( y == numRows - 1 && isDown ) {
                isDown = false;
            } else if ( y == 0 && !isDown ) {
                isDown = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Character> mc : m.entrySet()) {
            sb.append(mc.getValue());
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        ZigZagConversion instance = new ZigZagConversion();
        System.out.println(instance.convert("ABCDE", 4));
    }
}
