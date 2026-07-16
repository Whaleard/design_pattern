package singleton;

/**
 * 静态内部类缺点说明：
 *  1、这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
 *  2、静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
 *  3、类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 *  4、优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高。
 *  5、结论：推荐使用。
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton7 singleton = Singleton7.getInstance();
        Singleton7 singleton2 = Singleton7.getInstance();
        System.out.println(singleton == singleton2);
        System.out.println("instance.hashCode=" + singleton.hashCode());
        System.out.println("instance2.hashCode=" + singleton2.hashCode());
    }
}

/**
 * 静态内部类
 */
class Singleton7 {

    private Singleton7() {
    }

    /**
     * 提供一个静态内部类，该类中有一个静态属性Singleton.
     * 当外部类加载时，静态内部类不会立即加载，只有首次被使用时加载并初始化，从而实现延迟加载。
     */
    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    /**
     * 提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE。
     * @return
     */
    public static synchronized Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
