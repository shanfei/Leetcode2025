package com.concurrent;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExperiment {

    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(3);




        for (int i = 0; i < 3; ++i) {
            int finalI = i;
            Thread t = new Thread(new Runnable() {

                Random random = new Random();

                @Override
                public void run() {
//                    try {
//                        countDownLatch.await();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }

                   int sleepDuration = random.nextInt(1000);

                    try {
                        Thread.sleep(sleepDuration);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(finalI);

                    System.out.println("count down ");

                    countDownLatch.countDown();
                }
            });

            t.start();

        }

        countDownLatch.await();


    }
}
