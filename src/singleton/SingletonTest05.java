package singleton;

/**
 * 懒汉式（线程安全，同步代码块）优缺点说明：
 *  1、这种方式，本意是想对第四种实现方式的改进，因为前面同步方法效率太低，改为同步产生实例化的代码块。
 *  2、但是这种同步并不能起到线程同步的作用。
 *      跟第3种实现方式遇到的情形一致，假如从线程进入了if (instance == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 *  3、结论：在实际开发中，不能使用这种方式。
 */
public class SingletonTest05 {
    public static void main(String[] args) {
        Singleton5 singleton = Singleton5.getInstance();
        Singleton5 singleton2 = Singleton5.getInstance();
        System.out.println(singleton == singleton2);
        System.out.println("instance.hashCode=" + singleton.hashCode());
        System.out.println("instance2.hashCode=" + singleton2.hashCode());
    }
}

/**
 * 懒汉式（线程安全，同步代码块）
 */
class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {
    }

    /**
     * 提供一个静态的公有方法，加入同步处理的代码，未解决线程安全问题
     * @return
     */
    public static synchronized Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
