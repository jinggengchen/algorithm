package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 三个线程交替打印1到100 {
    static Lock lock = new ReentrantLock();
    static int state = 1;
    static int num = 1;
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    static Condition condition3 = lock.newCondition();
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    printA();
                }
            } catch (Exception e) {

            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    printB();
                }
            } catch (Exception e) {

            }
        },"B").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    printC();
                }
            } catch (Exception e) {

            }
        },"C").start();
    }

    private static void printA() {
        try {
            lock.lock();
            while (state != 1) {
                condition1.await();
            }
            if (num == 101) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "-" + num++);
            condition2.signal();
            state = 2;
        } catch (Exception e) {

        } finally {
            lock.lock();
        }
    }
    private static void printB() {
        try {
            lock.lock();
            while (state != 2) {
                condition2.await();
            }
            if (num == 101) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "-" + num++);
            condition3.signal();
            state = 3;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
    private static void printC() {
        try {
            lock.lock();
            while (state != 3) {
                condition3.await();
            }
            if (num == 101) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "-" + num++);
            condition1.signal();
            state = 1;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

}
