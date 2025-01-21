package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractProducerAndConsumer implements ProducerAndConsumer {

    protected volatile int capacity = 10;
    protected final List<Integer> cache = new ArrayList<>();
    protected Random random = new Random();
    protected volatile boolean done = false;

    AtomicInteger totalProducedCount = new AtomicInteger(0);

    @Override
    public boolean isDone() {
        return this.done;
    }

    @Override
    public void done() {
        this.done = true;
    }

    protected boolean isFull() {
        System.out.println(this.cache.size() == capacity);
        return this.cache.size() == capacity;
    }

    public boolean isEmpty() {
        return this.cache.isEmpty();
    }

    public int size() {
        return this.cache.size();
    }


}
