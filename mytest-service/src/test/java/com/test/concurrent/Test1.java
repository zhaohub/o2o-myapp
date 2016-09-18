package com.test.concurrent;

import java.text.ParseException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by zhaogang3 on 2016/6/23.
 */
public class Test1 {

    public static void main(String[] args) throws ParseException, InterruptedException {
        final BlockingQueue queue = new SynchronousQueue();

        Thread ta = new Thread(new Runnable() {
            int i = 0;

            public void run() {
                try {
                    for (; ; ) {
                        int a = i++;
                        queue.put(a);
                        System.out.println("put--" + a);
                        Thread.sleep(1000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread tb = new Thread(new Runnable() {
            int i = 0;

            public void run() {
                try {
                    for (; ; ) {
                        int a = i++;
                        System.out.println("take--" + queue.take());
                        //Thread.sleep(2000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        ta.start();
        tb.start();
        System.gc();
        System.out.println(queue.size());
        //queue.put(new Object());
        //ConcurrentLinkedQueue


    }
}

class TT {
    private Integer a = new Integer(1);

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }
}
