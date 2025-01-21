package com.leetcode.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficLight {

    private volatile int canPassRoad = 1;

    public TrafficLight() {

    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car 1,2,3,4
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {

        synchronized (this) {
            if (canPassRoad != roadId) {
                canPassRoad = roadId;
                turnGreen.run();
            }
            crossCar.run();
        }
    }

}
