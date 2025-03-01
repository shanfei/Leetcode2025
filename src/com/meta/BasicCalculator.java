package com.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {

//        int c = 0;
//
//        int r = 0;
//
//        List<Integer> numbers = new ArrayList<>();
//        List<Character> ops = new ArrayList<>();
//
//        for ( int i = 0; i < s.length(); ++i ) {
//
//            char cc = s.charAt(i);
//
//            if ( cc == '(' ) {
//                c++;
//            } else if ( cc == ')' ) {
//                c--;
//                // pop and calculate till '(' if c > 0
//                while ( !stack.isEmpty() && stack.peek() != '(' ) {
//                    calculateStack.push(stack.pop());
//                }
//
//                while ( !calculateStack.isEmpty() ) {
//                    int a = calculateStack.pop() - '0';
//                    char ops = calculateStack.pop();
//                    int b = calculateStack.pop() - '0';
//                    calculateStack.push(calculate(a, ops, b));
//                }
//
//            } else if (Character.isDigit(c)) {
//                // push char into stack
//                numbers.add(0, cc - '0');
//            } else if ( c == '-' ) {
//                if ()
//            }
//
//        }

        // if the stack if not empty then calculate the remain result
        return -1;
    }

    int calculate(int a, char ops, int b) {
        return switch (ops) {
            case '+' -> a + b;
            case '-' -> a - b;
            default -> 0;
        };
    }
}
