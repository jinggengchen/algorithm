package Thread;

import java.util.concurrent.Semaphore;

public class 三个线程交替打印1到100_2 {
    static int num = 0;
    static Semaphore semaphore1 = new Semaphore(1);
    static Semaphore semaphore2 = new Semaphore(0);
    static Semaphore semaphore3 = new Semaphore(0);
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                if (num < 100) {
                    printA();
                }
            } catch (Exception e) {

            }
        }, "A").start();

        new Thread(() -> {
            try {
                if (num < 100) {
                    printB();
                }
            } catch (Exception e) {

            }
        },"B").start();

        new Thread(() -> {
            try {
                if (num < 100) {
                    printC();
                }
            } catch (Exception e) {

            }
        },"C").start();
    }

    private static void printA() throws InterruptedException {
        semaphore1.acquire();
        num = num + 1;
        System.out.println(Thread.currentThread().getName() + "-" + num );
        semaphore2.release();
    }
    private static void printB() throws InterruptedException {
        semaphore2.acquire();
        num = num + 1;
        System.out.println(Thread.currentThread().getName() + "-" + num);
        semaphore3.release();
    }
    private static void printC() throws InterruptedException {
        semaphore3.acquire();
        num = num + 1;
        System.out.println(Thread.currentThread().getName() + "-" + num );
        semaphore1.release();
    }
}
