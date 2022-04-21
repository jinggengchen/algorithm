package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 线程安全:
 * 把StringBuilder换成StringBuffer 输出500
 * 给update加锁 输出500
 * 把newCachedThreadPool换成newSingleThreadPool 输出500
 */
public class StringExample1 {
    public static int clientTotal = 5000;
    public static int threadTotal = 200;
    public static StringBuilder sb = new StringBuilder();

    private static void update () {
        sb.append("1");
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(sb.length());
    }
}
