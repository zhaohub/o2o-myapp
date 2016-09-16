import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaogang3 on 2016/8/12.
 */
public class Market {
    private static Entrance[] entrances = new Entrance[100];

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(8, 8, 10, TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(99), new ThreadPoolExecutor.AbortPolicy());
        Counter counter = new Counter();

        CyclicBarrier barrier = new CyclicBarrier(10);
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < entrances.length; i++) {
            entrances[i] = new Entrance("NO" + i, counter, latch);
            executorService.execute(entrances[i]);
        }
        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();

        latch.await();
        System.out.println(counter.getCount());
    }
}
