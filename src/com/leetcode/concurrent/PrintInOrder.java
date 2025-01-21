package com.leetcode.concurrent;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads.
 * Thread A will call first(),
 * thread B will call second(),
 * and thread C will call third().
 * Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 *
 * Note:
 *
 * We do not know how the threads will be scheduled in the operating system,
 * even though the numbers in the input seem to imply the ordering.
 * The input format you see is mainly to ensure our tests' comprehensiveness.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously.
 * The input [1,2,3] means thread A calls first(), thread B calls second(),
 * and thread C calls third().
 * "firstsecondthird" is the correct output.
 * Example 2:
 *
 * Input: nums = [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 *
 */
public class PrintInOrder {

    //ReentrantLock lock = new ReentrantLock();

    //Condition firstRunCompleted = lock.newCondition(), secondRunCompleted = lock.newCondition();

    //volatile boolean isFirstRunCompleted = false, isSecondRunCompleted = false;

    AtomicBoolean isFirstRunCompleted = new AtomicBoolean(false),  isSecondRunCompleted = new AtomicBoolean(false);

    public void first(Runnable printFirst) throws InterruptedException {


            printFirst.run();

            isFirstRunCompleted.compareAndSet(false, true);

    }

    public void second(Runnable printSecond) throws InterruptedException {

            while (!isFirstRunCompleted.get()) {
                Thread.yield();
            }
            printSecond.run();

            isSecondRunCompleted.compareAndSet(false, true);

    }

    public void third(Runnable printThird) throws InterruptedException {


            while (!isSecondRunCompleted.get()) {
                Thread.yield();
            }

            printThird.run();


    }

    public static void main(String[] args) throws InterruptedException {

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("first | ");
            }
        };

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("second | ");
            }
        };

        Runnable t3 = new Runnable() {
            @Override
            public void run() {
                System.out.print("third | ");
            }
        };









    }
}
