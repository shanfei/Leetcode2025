package com.meta.binarysearch;

import java.util.*;

class MyHeapNode {

    int row;
    int column;
    int value;

    public MyHeapNode(int v, int r, int c) {
        this.value = v;
        this.row = r;
        this.column = c;
    }

    public int getValue() {
        return this.value;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}



public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int col = Math.min(matrix.length, k);

        PriorityQueue<MyHeapNode> pq = new PriorityQueue<>( (a, b) -> {
            return a.value - b.value;
        });

        for ( int i = 0; i < col; ++i ) {
            MyHeapNode v = new MyHeapNode(matrix[i][0], i, 0);
            pq.offer(v);
        }

        MyHeapNode ret = pq.peek();

        while ( k-- > 0 ) {

            ret = pq.poll();

            int x = ret.getRow();
            int y = ret.getColumn();

            if ( y < matrix[x].length - 1 ) {
                pq.offer(new MyHeapNode(matrix[x][y + 1], x, y + 1));
            }
        }


        return ret.getValue();
    }


}
