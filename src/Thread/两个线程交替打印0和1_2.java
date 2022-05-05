package Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 两个线程交替打印0和1_2 {
    static Semaphore semaphore1 = new Semaphore(1);
    static Semaphore semaphore2 = new Semaphore(0);
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                printB();
            }
        }, "B").start();
    }


    private static void printB() {
        try {
            semaphore2.acquire();
            System.out.println(Thread.currentThread().getName() + "0");
            semaphore1.release();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    private static void printA() {
        try {
            semaphore1.acquire();
            System.out.println(Thread.currentThread().getName() + "1");
            semaphore2.release();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
