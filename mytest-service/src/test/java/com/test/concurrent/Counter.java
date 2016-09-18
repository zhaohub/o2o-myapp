package com.test.concurrent;

/**
 * Created by zhaogang3 on 2016/8/12.
 */
public final class Counter {

    private long count;

    public long incAndGet() {
        return ++count;
    }

    public long decAndGet() {
        return --count;
    }

    public long getCount() {
        return count;
    }

    public synchronized void add(long count) {
        this.count += count;
    }
}
