package com.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaogang3 on 2017/8/24.
 */
public class TestLock {

    private static int THREAD_POOL_SIZE = 4;

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_SIZE, THREAD_POOL_SIZE, 2000, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(2000), new ThreadPoolExecutor.AbortPolicy());

    private static int totalTimes = 40000000;

    private static Lock lock = new ReentrantLock();

    private static int syncAddNum = 0;
    private static AtomicInteger atomicAddNum = new AtomicInteger();
    private static int lockAddNum = 0;
    private static int serialAddNum = 0;

    private static CyclicBarrier barrier = new CyclicBarrier(THREAD_POOL_SIZE + 1);


    public static void main(String[] args) {
        TestLock test = new TestLock();
        test.testSyncAdd();

        test.testAtomicAdd();
        test.testLockAdd();
        test.testSerialAdd();
    }

    public void testSyncAdd() {
        barrier.reset();
        long t = System.currentTimeMillis();
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executor.execute(new SyncAddThread());
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("testSyncAdd cost time:" + (System.currentTimeMillis() - t) + "result:" + syncAddNum);
    }

    public void testSerialAdd() {
        barrier.reset();
        long t = System.currentTimeMillis();
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executor.execute(new SyncAddThread());
        }
        System.out.println("testSyncAdd cost time:" + (System.currentTimeMillis() - t) + "result:" + serialAddNum);
    }

    public void testAtomicAdd() {
        barrier.reset();
        long t = System.currentTimeMillis();
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executor.execute(new SyncAddThread());
        }
        System.out.println("testSyncAdd cost time:" + (System.currentTimeMillis() - t) + "result:" + atomicAddNum.get());
    }

    public void testLockAdd() {
        barrier.reset();
        long t = System.currentTimeMillis();
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executor.execute(new SyncAddThread());
        }
        System.out.println("testSyncAdd cost time:" + (System.currentTimeMillis() - t) + "result:" + lockAddNum);
    }


    class SerialAddThread implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < totalTimes; i++) {
                    serialAdd();
                }
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void serialAdd() {
            serialAddNum++;
        }
    }

    class AtomicAddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < totalTimes; i++) {
                atomicAdd();
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void atomicAdd() {
            atomicAddNum.incrementAndGet();
        }
    }

    class LockAddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < totalTimes; i++) {
                loadAdd();
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void loadAdd() {
            lock.lock();
            try {
                lockAddNum++;
            } finally {
                lock.unlock();
            }
        }
    }

    class SyncAddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < totalTimes; i++) {
                synchronized (SyncAddThread.class) {
                    syncAddNum++;
                }
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


}
