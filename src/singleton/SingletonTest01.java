package singleton;

/**
 * 饿汉式（静态变量）优缺点说明：
 *  1、优点：写法简单，在类装载的时候就完成实例化，避免了线程同步问题。
 *  2、缺点：类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存浪费。
 *  3、这种方式基于classloader机制，避免了多线程的同步问题。不过，instance在类装载时就实例化，在单例模式中大多数都是调用getInstance方法。
 *      但是导致类装载的原因有很多种，因此不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance就没有达到lazy loading的效果。
 *  4、结论：这种单例模式可用，可能造成内存浪费。
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
        System.out.println("instance.hashCode=" + singleton.hashCode());
        System.out.println("instance2.hashCode=" + singleton2.hashCode());
    }
}

/**
 * 饿汉式（静态变量）
 */
class Singleton {
    /**
     * 1、构造器私有化，防止外部new
     */
    private Singleton() {
    }

    /**
     * 2、在本类内部创建对象实例
     */
    private final static Singleton instance = new Singleton();

    /**
     * 3、提供一个公共的静态方法，返回对象实例
     * @return
     */
    public static Singleton getInstance() {
        return instance;
    }
}
