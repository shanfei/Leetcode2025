package com.designguru.code.pattern.heap.twoheaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Given a set of investment projects with their respective profits, we need to find the most profitable projects. We are given an initial capital and are allowed to invest only in a fixed number of projects. Our goal is to choose projects that give us the maximum profit. Write a function that returns the maximum total capital after selecting the most profitable projects.
 *
 * We can start an investment project only when we have the required capital. After selecting a project, we can assume that its profit has become our capital, and that we have also received our capital back.
 *
 * Example 1:
 *
 * Input: Project Capitals=[0,1,2], Project Profits=[1,2,3], Initial Capital=1, Number of Projects=2
 *
 * Output: 6
 *
 * Explanation:
 * 1. With initial capital of ‘1’, we will start the second project which will give us profit of ‘2’. Once we selected our first project, our total capital will become 3 (profit + initial capital).
 * 2. With ‘3’ capital, we will select the third project, which will give us ‘3’ profit.
 *
 * After the completion of the two projects, our total capital will be 6 (1+2+3).
 * Example 2:
 *
 * Input: Project Capitals=[0,1,2,3], Project Profits=[1,2,3,5], Initial Capital=0, Number of Projects=3
 *
 * Output: 8
 *
 * Explanation:
 *
 * 1. With ‘0’ capital, we can only select the first project, bringing out capital to 1.
 * 2. Next, we will select the second project, which will bring our capital to 3.
 * 3. Next, we will select the fourth project, giving us a profit of 5.
 *
 * After selecting the three projects, our total capital will be 8 (1+2+5).
 *
 */
public class MaximCapital {


    public  int findMaximumCapital(int[] capital, int[] profits,int numberOfProjects, int initialCapital) {
        List<Project> projects = new ArrayList<>();

        for ( int i = 0; i < capital.length; i++ ) {
            projects.add( new Project(i, capital[i], profits[i]) );
        }

        // min heap
        PriorityQueue<Project> capitalHeap = new PriorityQueue<Project>( (p1, p2 )  -> {
            return p1.capital - p2.capital;
        });

        // max heap
        PriorityQueue<Project> profitHeap = new PriorityQueue<Project>( ( p1, p2 ) -> {
            return p2.profit - p1.profit;
        });

        for ( Project p : projects ) {
            capitalHeap.offer(p);
        }

        int totalProfit = initialCapital;

        for (int i = 0; i < numberOfProjects; i++) {

            while ( !capitalHeap.isEmpty() && capitalHeap.peek().capital <= totalProfit ) {
                profitHeap.offer(capitalHeap.poll());
            }

            if (profitHeap.isEmpty()) {
                break;
            }

            totalProfit += profitHeap.poll().profit;

        }

        return totalProfit;
    }
}

class Project {

    public int capital;

    public int profit;

    public int index;

    public Project(int index, int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
        this.index = index;
    }

    public Project() {
    }
}

