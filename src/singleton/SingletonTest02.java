package singleton;

/**
 * 饿汉式（静态代码块）优缺点说明：
 *  1、这种方式和静态变量的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和静态变量的方式是一样的。
 *  2、结论：这种单例模式可用，可能造成内存浪费。
 */
public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton2 singleton = Singleton2.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton == singleton2);
        System.out.println("instance.hashCode=" + singleton.hashCode());
        System.out.println("instance2.hashCode=" + singleton2.hashCode());
    }
}

/**
 * 饿汉式（静态代码块）
 */
class Singleton2 {
    /**
     * 1、构造器私有化，防止外部new
     */
    private Singleton2() {
    }

    private static Singleton2 instance;

    /**
     * 2、在静态代码块中创建对象实例
     */
    static {
        instance = new Singleton2();
    }

    /**
     * 3、提供一个公共的静态方法，返回对象实例
     * @return
     */
    public static Singleton2 getInstance() {
        return instance;
    }
}
