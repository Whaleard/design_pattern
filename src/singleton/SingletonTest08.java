package singleton;

/**
 * 枚举缺点说明：
 *  1、借助JDK1.5中添加的枚举来实现单例模式，不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 *  2、结论：推荐使用。
 */
public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton8 singleton = Singleton8.INSTANCE;
        Singleton8 singleton2 = Singleton8.INSTANCE;
        System.out.println(singleton == singleton2);
        System.out.println("instance.hashCode=" + singleton.hashCode());
        System.out.println("instance2.hashCode=" + singleton2.hashCode());
    }
}

/**
 * 枚举
 */
enum Singleton8 {
    INSTANCE;
}
