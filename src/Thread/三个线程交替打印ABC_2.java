package Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 分析：三个线程交替执行。
 * 交替，也就是说A执行完必须B执行，B执行完必须C执行，C执行完必须A执行。
 * 那么也就是说A线程执行完，只能唤醒B线程。B线程执行完，只能唤醒C线程。C线程执行完，只能唤醒A线程。
 * 以此类推。所以即实现线程的精准唤醒。精准唤醒需要用到Condition类，配合Lock。去实现。
 *
 * 还有一种方式，使用Semaphore，Semaphore叫做信号量，他的底层也是AQS。
 * Semaphore的构造方法里面，需要传入一个变量，这个变量其实设置的是AQS中state中的值。
 * 同时Semaphore具有公平锁和非公平锁之分，可以在构造参数里面进行设置。
 * Semaphore还有2个重要的方法，acquire()方法和release()方法。
 * acquire()方法里对state变量进行CAS减操作。减到0的时候，线程阻塞。
 * release()方法里对state变量进行CAS加操作。
 *
 * state他的业务含义是：资源的总数，比如说state的值是1，
 * 那么n个线程只有1个线程会获取到该资源，其他的线程都会阻塞。
 * 直到有线程释放了该资源。其他线程才能获取到。
 *
 */
public class 三个线程交替打印ABC_2 {

    static Semaphore semaphore1 = new Semaphore(1);
    static Semaphore semaphore2 = new Semaphore(0);
    static Semaphore semaphore3 = new Semaphore(0);
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphore1.acquire();
                    System.out.println(Thread.currentThread().getName() + ": " + "A");
                    semaphore2.release();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphore2.acquire();
                    System.out.println(Thread.currentThread().getName() + ": " + "B");
                    semaphore3.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }, "B").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphore3.acquire();
                    System.out.println(Thread.currentThread().getName() + ": " + "C");
                    semaphore1.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }, "C").start();
    }
}