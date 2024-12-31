package com.designguru.code.pattern.heap.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * Design a class that simulates a Stack data structure, implementing the following two operations:
 *
 * push(int num): Pushes the number ‘num’ on the stack.
 * pop(): Returns the most frequent number in the stack. If there is a tie, return the number which was pushed later.
 * Example:
 *
 * After following push operations: push(1), push(2), push(3), push(2), push(1), push(2), push(5)
 *
 * 1. pop() should return 2, as it is the most frequent number
 * 2. Next pop() should return 1
 * 3. Next pop() should return 2
 *
 */

class NumWithFrequencyWithIndex<T> {
    public T key;
    public int frequency;
    public int index;

    public NumWithFrequencyWithIndex(T num, int frequency) {
        this.key = num;
        this.frequency = frequency;
    }

    public NumWithFrequencyWithIndex(T num, int frequency, int index) {
        this.key = num;
        this.frequency = frequency;
        this.index = index;
    }
}

public class FrequencyStack {

    int index = 0;

    PriorityQueue<NumWithFrequencyWithIndex<Integer>> pq =
            new PriorityQueue<>((a,b) ->  {
                if ( b.frequency != a.frequency ) {
                    return b.frequency - a.frequency;
                }

                return b.index - a.index;
            } );

    Map<Integer,  Integer> m = new HashMap<>();

    public void push(int num) {
        m.put(num, m.getOrDefault(num,  0) + 1 );
        pq.offer(new NumWithFrequencyWithIndex<>(num, m.get(num), index++));
    }

    public int pop() {

        NumWithFrequencyWithIndex<Integer> me = pq.poll();
        int f = m.get(me.key);

        if ( f > 1 ) {
            m.put(me.key, f - 1);
        } else {
            m.remove(me.key);
        }

        return me.key;
    }

}
