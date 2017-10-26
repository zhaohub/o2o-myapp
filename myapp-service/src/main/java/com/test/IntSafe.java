package com.test;

/**
 * Created by zhaogang3 on 2017/8/24.
 */


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class IntSafe {

    private static int testAdd = 0;
    private static int testLcok = 0;
    private static int testAddSyn = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public void add() {
        testAdd++;
    }

    public synchronized void addSyn() {
        testAddSyn++;
    }

    public void addAtom() {
        atomicInteger.incrementAndGet();
    }

    public void addLock() {
        testLcok++;
    }

    public static void main(String[] args) {
        try {
            IntSafe intSafe = new IntSafe();
            long start = System.currentTimeMillis();
            intSafe.testMethod();
            long end = System.currentTimeMillis();
            System.err.println(IntSafe.testAdd + "          testAdd      耗时：" + (end - start) + "ms");

            start = System.currentTimeMillis();
            intSafe.testMethodSyn();
            end = System.currentTimeMillis();
            System.err.println(IntSafe.testAddSyn + "          testAddSyn   耗时：" + (end - start) + "ms");

            start = System.currentTimeMillis();
            intSafe.testMethodAtom();
            end = System.currentTimeMillis();
            System.err.println(IntSafe.atomicInteger + "          testAddAtom  耗时：" + (end - start) + "ms");

            start = System.currentTimeMillis();
            intSafe.testMethodLcok();
            end = System.currentTimeMillis();
            System.err.println(IntSafe.testLcok + "          testIntLock  耗时：" + (end - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class ThreadTest implements Runnable {
        CyclicBarrier cyclicBarrier=null;
        public ThreadTest(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier=cyclicBarrier;
        }

        @Override
        public void run() {
            testInt();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void testInt() {
        for (int i = 0; i < 10000000; i++) {
            add();
        }
    }

    public void testMethod() throws Exception{
        CyclicBarrier cyclicBarrier=new CyclicBarrier(9);
        Thread th1 = new Thread(new ThreadTest(cyclicBarrier));
        Thread th2 = new Thread(new ThreadTest(cyclicBarrier));
        Thread th3 = new Thread(new ThreadTest(cyclicBarrier));
        Thread th4 = new Thread(new ThreadTest(cyclicBarrier));
        Thread th11 = new Thread(new ThreadTest(cyclicBarrier));
        Thread th21 = new Thread(new ThreadTest(cyclicBarrier));
        Thread th31 = new Thread(new ThreadTest(cyclicBarrier));
        Thread th41 = new Thread(new ThreadTest(cyclicBarrier));
        th1.start();
        th2.start();
        th3.start();
        th4.start();

        th11.start();
        th21.start();
        th31.start();
        th41.start();
        cyclicBarrier.await();
    }

    public class ThreadTestSyn implements Runnable {
        CyclicBarrier cyclicBarrier=null;
        public ThreadTestSyn(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier=cyclicBarrier;
        }

        @Override
        public void run() {
            testIntSyn();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void testIntSyn() {
        for (int i = 0; i < 10000000; i++) {
            addSyn();
        }
    }

    public void testMethodSyn() throws Exception{
        CyclicBarrier cyclicBarrier=new CyclicBarrier(9);
        Thread th1 = new Thread(new ThreadTestSyn(cyclicBarrier));
        Thread th2 = new Thread(new ThreadTestSyn(cyclicBarrier));
        Thread th3 = new Thread(new ThreadTestSyn(cyclicBarrier));
        Thread th4 = new Thread(new ThreadTestSyn(cyclicBarrier));
        Thread th11 = new Thread(new ThreadTestSyn(cyclicBarrier));
        Thread th21 = new Thread(new ThreadTestSyn(cyclicBarrier));
        Thread th31 = new Thread(new ThreadTestSyn(cyclicBarrier));
        Thread th41 = new Thread(new ThreadTestSyn(cyclicBarrier));
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th11.start();
        th21.start();
        th31.start();
        th41.start();
        cyclicBarrier.await();
    }

    public class ThreadTestAtom implements Runnable {
        CyclicBarrier cyclicBarrier=null;
        public ThreadTestAtom(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier=cyclicBarrier;
        }
        @Override
        public void run() {
            testIntAtom();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    class ThreadTestLock implements Runnable {
        Lock lock=null;
        public ThreadTestLock(Lock lock){
            this.lock=lock;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                lock.lock();
                try {
                    testIntLock();
                }finally {
                    lock.unlock();
                }
            }

        }
    }

    public void testIntAtom() {
        for (int i = 0; i < 10000000; i++) {
            addAtom();
        }
    }
    public void testIntLock() {
        addLock();
    }

    public void testMethodAtom() throws Exception{
        CyclicBarrier cyclicBarrier=new CyclicBarrier(9);
        Thread th1 = new Thread(new ThreadTestAtom(cyclicBarrier));
        Thread th2 = new Thread(new ThreadTestAtom(cyclicBarrier));
        Thread th3 = new Thread(new ThreadTestAtom(cyclicBarrier));
        Thread th4 = new Thread(new ThreadTestAtom(cyclicBarrier));
        Thread th11 = new Thread(new ThreadTestAtom(cyclicBarrier));
        Thread th21 = new Thread(new ThreadTestAtom(cyclicBarrier));
        Thread th31 = new Thread(new ThreadTestAtom(cyclicBarrier));
        Thread th41 = new Thread(new ThreadTestAtom(cyclicBarrier));
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th11.start();
        th21.start();
        th31.start();
        th41.start();
        cyclicBarrier.await();
    }

    public void testMethodLcok() throws Exception{
        Lock lock=new ReentrantLock();
        Thread th1 = new Thread(new ThreadTestLock(lock));
        Thread th2 = new Thread(new ThreadTestLock(lock));
        Thread th3 = new Thread(new ThreadTestLock(lock));
        Thread th4 = new Thread(new ThreadTestLock(lock));
        Thread th11 = new Thread(new ThreadTestLock(lock));
        Thread th21 = new Thread(new ThreadTestLock(lock));
        Thread th31 = new Thread(new ThreadTestLock(lock));
        Thread th41 = new Thread(new ThreadTestLock(lock));
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th11.start();
        th21.start();
        th31.start();
        th41.start();
        th1.join();
        th2.join();
        th3.join();
        th4.join();
        th11.join();
        th21.join();
        th31.join();
        th41.join();
    }
}

