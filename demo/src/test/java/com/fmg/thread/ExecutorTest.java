package com.fmg.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @classs: ExecutorTest
 * @author: fengmg
 * @date: 2019/12/24 11:31
 * @description:
 * @version: 1.0
 */
public class ExecutorTest {

    @Test
    public void executeTest() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        threadPool.execute(() -> {
            try {
                Thread.sleep(1000L*3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2*3);
        });
        Thread.sleep(1000L*100);
    }

    @Test
    public void submitTest() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        Future<Integer> future = threadPool.submit(() -> {
            try {
                Thread.sleep(1000L * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 3 * 3;
        });

        System.out.println(future.get());
    }
}
