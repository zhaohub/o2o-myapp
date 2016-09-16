import java.util.concurrent.CountDownLatch;

/**
 * Created by zhaogang3 on 2016/8/12.
 */
public class Entrance implements Runnable {

    private String name;
    private Counter counter;
    private CountDownLatch latch;

    public Entrance(String name, Counter counter, CountDownLatch latch) {
        this.name = name;
        this.counter = counter;
        this.latch = latch;
    }

    public long getCount() {
        return counter.getCount();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //Random random = new Random(10);
            int n = 1;
            if (n > 0) {
                //System.out.println("入口" + name + "来了" + n + "位顾客！");
                counter.add(n);
            }
        }
        latch.countDown();
    }
}
