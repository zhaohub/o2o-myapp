import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaogang3 on 2016/8/22.
 */
public class ThreadPool {


    public static void main(String[] args) {


        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 10, TimeUnit.DAYS,
                new LinkedBlockingQueue<Runnable>(100), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 101; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("finished");

        executorService.shutdownNow();
        System.out.println("terminated" + executorService.isTerminated());
    }
}
