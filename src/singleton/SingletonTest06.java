package singleton;

/**
 * 双重检查优缺点说明：
 *  1、Double-Check概念是多线程开发中常使用到的。如代码中所示，我们进行了两次if (instance == null)检查，这样就可以保证线程安全了。
 *  2、实例化代码只用执行一次，后面再次访问时，判断if (instance == null)，直接return实例化对象，也避免了反复进行方法同步。
 *  3、线程安全，延迟加载，效率较高。
 *  4、结论：在实际开发中，推荐使用这种单例设计模式。
 */
public class SingletonTest06 {
    public static void main(String[] args) {
        Singleton6 singleton = Singleton6.getInstance();
        Singleton6 singleton2 = Singleton6.getInstance();
        System.out.println(singleton == singleton2);
        System.out.println("instance.hashCode=" + singleton.hashCode());
        System.out.println("instance2.hashCode=" + singleton2.hashCode());
    }
}

/**
 * 双重检查
 */
class Singleton6 {
    private static volatile Singleton6 instance;

    private Singleton6() {
    }

    /**
     * 提供一个静态的公有方法，加入双重检查，解决线程安全问题，同时解决懒加载问题。
     * @return
     */
    public static synchronized Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
