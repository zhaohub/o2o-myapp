package com.test.lock;

import java.util.concurrent.*;

/**
 * Created by zhaogang3 on 2017/7/12.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        execute();
        System.out.println(11111);
    }

    private static void execute() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(10);
        for (int i = 1; i <= 10; i++) {
            executorService.execute(new Player(i + "号选手 ", barrier));
        }
        executorService.shutdown();
    }
}

class Player implements Runnable {
    private String name;
    private CyclicBarrier barrier;

    public Player(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "准备完成");
            barrier.await();
            System.out.println(name + "起跑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}