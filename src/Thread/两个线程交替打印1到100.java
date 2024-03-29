package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 两个线程交替打印1到100 {

    private static int state = 1;
    static int num = 0;
    static Lock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    static Condition condition3 = lock.newCondition();
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

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                printC();
            }
        }, "C").start();
    }


    private static void printB() {
        try {
            lock.lock();
            while (state != 0) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + ": " + num++);
            state = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void printC() {
        try {
            lock.lock();
            while (state != 0) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + ": " + num++);
            state = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //
    private static void printA() {
        try {
            lock.lock();
            while (state != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + ": " + num++);
            state = 0;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
