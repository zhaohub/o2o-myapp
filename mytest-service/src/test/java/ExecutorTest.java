import java.util.concurrent.*;

/**
 * Created by zhaogang3 on 2016/8/12.
 */
public class ExecutorTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executor = new ThreadPoolExecutor(8, 8, 8, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(10), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 100; i++) {
            Future future = executor.submit(new Callable<Object>() {
                public Object call() throws Exception {
                    return 1 + 1;
                }
            });
        }


        //System.out.println("1---" + future.get());

        FutureTask task = new FutureTask(new Callable() {
            public Object call() throws Exception {
                return new Integer(1);
            }
        });

        executor.submit(task);

        System.out.println("2---" + task.get());
    }
}
