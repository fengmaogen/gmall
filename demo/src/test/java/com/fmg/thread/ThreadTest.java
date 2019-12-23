package com.fmg.thread;

import net.minidev.json.JSONUtil;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @classs: ThreadTest
 * @author: fengmg
 * @date: 2019/12/20 10:25
 * @description:
 * @version: 1.0
 */
public class ThreadTest {

    @Test
    public void newHandle() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                System.out.println("文档处理开始");
                try {
                    Thread.sleep(1000L*30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束");
            });
        }

        Thread.sleep(1000L*1000);
    }

    @Test
    public void oldHandle() throws InterruptedException {

        for (int i = 0; i <= 100; i++) {
            new Thread(() -> {
                System.out.println("文档处理开始");
                try {
                    Thread.sleep(1000L*30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束");
            }).start();
        }
        Thread.sleep(1000L*1000);

    }
}
