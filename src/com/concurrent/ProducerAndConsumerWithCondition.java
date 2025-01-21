package com.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ProducerAndConsumerWithCondition extends AbstractProducerAndConsumer {

    ReentrantLock lock = new ReentrantLock();

    Condition isFull = lock.newCondition(), isEmpty = lock.newCondition();


    @Override
    public void produce() throws InterruptedException {

        lock.lock();

        try {

            while (this.isFull()) {
                isFull.await();
            }

            // Generate a random integer between 0 (inclusive) and 100 (exclusive)
            int randomNumber = random.nextInt(100);
            cache.add(randomNumber);
            System.out.println(this.cache.size());

            isEmpty.signal();

            System.out.println(totalProducedCount.incrementAndGet());

        } finally {
            lock.unlock();
        }
    }

    @Override
    public void consume() throws InterruptedException {

        lock.lock();

        try {

            while (this.cache.isEmpty()) {
                isEmpty.await();
            }

            System.out.println("Consuming: " + cache.removeFirst());

            isFull.signal();

        } finally {
            lock.unlock();
        }


    }


}




