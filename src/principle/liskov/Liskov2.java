package principle.liskov;

/**
 * 里氏替换原则方案二分析：
 */
public class Liskov2 {
    public static void main(String[] args) {
        A2 a2 = new A2();
        System.out.println("11-3=" + a2.fun1(11, 3));
        System.out.println("1-8=" + a2.fun1(1, 8));

        System.out.println("------------------------------");
        B2 b2 = new B2();
        System.out.println("11+3=" + b2.fun1(11, 3));
        System.out.println("1+8=" + b2.fun1(1, 8));
        System.out.println("11+3+9=" + b2.fun2(11, 3));

        System.out.println("11-3=" + b2.fun3(11, 3));
    }
}

class Base {

}

class A2 extends Base {
    public int fun1(int num1, int num2) {
        return num1 - num2;
    }
}

class B2 extends Base {
    /**
     * 如果B2需要使用A2类的方法，使用组合关系
     */
    private A2 a = new A2();

    public int fun1(int a, int b) {
        return a + b;
    }

    public int fun2(int a, int b) {
        return fun1(a, b) + 9;
    }

    public int fun3(int a, int b) {
        return this.a.fun1(a, b);
    }
}
