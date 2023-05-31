package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 分析：三个线程交替执行。
 * 交替，也就是说A执行完必须B执行，B执行完必须C执行，C执行完必须A执行。
 * 那么也就是说A线程执行完，只能唤醒B线程。B线程执行完，只能唤醒C线程。C线程执行完，只能唤醒A线程。
 * 以此类推。所以即实现线程的精准唤醒。精准唤醒需要用到Condition类，配合Lock。去实现。
 *
 */
public class 三个线程交替打印ABC {
    private static int state = 1;
    private static int sum = 0;
    static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                printA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                printB();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                printC();
            }
        }).start();
    }

    public static void printA() {
        lock.lock();
        try {
            // 打印A需要满足state = 1
            while (state != 1) {
                conditionA.await();
            }
            if (sum == 100) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + sum++);
            conditionB.signal();
            state = 2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    private static void printB() {
        lock.lock();
        try {
            while (state != 2) {
                conditionB.await();
            }
            if (sum == 100) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + sum++);
            conditionC.signal();
            state = 3;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    private static void printC() {
        lock.lock();
        try {
            while (state != 3) {
                conditionC.await();
            }
            if (sum == 100) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + sum++);
            conditionA.signal();
            state = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
