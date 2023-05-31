package Thread;

import lombok.Synchronized;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton1 {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor c = null;
        try {
            c = Class.forName("Thread.Singleton1").getDeclaredConstructor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (c != null) {
            c.setAccessible(true);
            Singleton1 o1 = (Singleton1)c.newInstance();
            Singleton1 o2 = (Singleton1)c.newInstance();
            System.out.println(o1.equals(o2));
        }
    }
    private static volatile Singleton1 singleton1;
    private Singleton1() {
    }
    public static Singleton1 getSingleton() {
        if (singleton1 == null) {
            // AB线程都会抢锁
            synchronized (Singleton1.class) {
                if (singleton1 == null) {
                    // 创建对象的过程会分为3部：（不是一个原子操作）
                    // 1。分配内存
                    // 2。初始化
                    // 3。对象指向内存地址
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
