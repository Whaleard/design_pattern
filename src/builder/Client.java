package builder;

/**
 * 传统方式解决盖房需求问题分析：
 *  1、优点是比较好理解，简单易操作。
 *  2、设计的程序结构过于简单，没有设计缓存层对象，程序的扩展和维护不好。
 *      也就是说，这种设计方案，把产品（即房子）和创建产品的过程（即盖房子流程）封装在一起，耦合性增强了。
 */
public class Client {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }
}
