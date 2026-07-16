package singleton;

/**
 * 懒汉式（线程不安全）优缺点说明：
 *  1、起到了Lazy Loading的效果，但是只能在单线程下使用。
 *  2、如果在多线程下，一个线程进入了if (instance == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 *      所以在多线程环境下不可使用这种方式。
 *  3、结论：在实际开发中，不要使用这种方式。
 */
public class SingletonTest03 {
    public static void main(String[] args) {
        Singleton3 singleton = Singleton3.getInstance();
        Singleton3 singleton2 = Singleton3.getInstance();
        System.out.println(singleton == singleton2);
        System.out.println("instance.hashCode=" + singleton.hashCode());
        System.out.println("instance2.hashCode=" + singleton2.hashCode());
    }
}

/**
 * 懒汉式（线程不安全）
 */
class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }

    /**
     * 提供一个静态的公有方法，当使用到该方法时，才创建instance
     * @return
     */
    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
