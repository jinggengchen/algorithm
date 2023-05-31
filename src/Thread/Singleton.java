package Thread;

public class Singleton {
    private static Singleton singleton = null;
    // 其他类不能通过new的方式来创建对象了
    // 需要使用Singleton只能调用方法

    // 这种方式其实是我们在用到的时候才会去创建对象，并不是程序一启动就直接new了一个出来。所以这样的方式是懒加载的方式
    // 好处：如果说一个对象的创建过程是比较复杂的，如果项目已启动就创建，万一没有被调用过，那么就会造成浪费。只有真正使用了才去创建。
    //      这样才是合理的。
    private Singleton() {

    }
    // 方法加上synchronized 能够保证 同一时刻只有一个线程进入到这个方法里面。
    // 但是这种方式也有问题，我们希望是在构建对象的时候去做同步，而不是直接同步一个方法，
    // 所以我们可以吧synchronized  加在new对象的时候
    public static  Singleton getSingleton() {
        // 这个是线程不安全的，如果有多个线程进来，他们同时判断了singleton是null，可能多个线程都会去创建singleton对象
        if (singleton == null) {
            //
            // 如果多个线程都来获取对象，都发现对象是null的，这个时候多个线程再来争抢锁资源
            // 抢到锁的那个线程开始创建对象。当对象创建完成之后，之后所有的线程，都可以直接拿到这个对象，就不用进入到synchronized同步代码块了
            synchronized (Singleton.class) {
                if (singleton == null) {
                    // 但是这种写法还有一个问题，就是如果AB两个线程此时都执行到了if条件判断里面。他们都回去抢锁，A线程执行完，创建了对象，释放了锁B对象会直接获取锁，再次创建一个对象
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
