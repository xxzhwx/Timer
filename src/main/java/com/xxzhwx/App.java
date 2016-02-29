package com.xxzhwx;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        HashedWheelTimer timer = new HashedWheelTimer(Executors.defaultThreadFactory(), 50, TimeUnit.MILLISECONDS, 1024);
        timer.start();

        for (int i = 0; i < 10; ++i) {
            timer.newTimeout(timeout -> System.out.println("now: " + System.currentTimeMillis()), i, TimeUnit.SECONDS);
        }

        TimeUnit.SECONDS.sleep(10);
        Set<Timeout> unprocessedTimeouts = timer.stop();
        System.out.println("Unprocessed timeout size: " + unprocessedTimeouts.size());
    }
}
