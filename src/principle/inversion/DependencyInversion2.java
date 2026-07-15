package principle.inversion;

/**
 * 依赖倒置原则方案二分析：
 *  1、通过接口传递实现依赖。
 */
public class DependencyInversion2 {
    public static void main(String[] args) {
        // 客户端无需改变
        Person2 person2 = new Person2();
        person2.receive(new Email2());

        person2.receive(new WeiXin());
    }
}

/**
 * 定义接口
 */
interface IReceiver {
    public String getInfo();
}

class Email2 implements IReceiver {
    public String getInfo() {
        return "电子邮件信息：hello world";
    }
}

/**
 * 增加微信
 */
class WeiXin implements IReceiver {
    public String getInfo() {
        return "微信信息：hello ok";
    }
}

class Person2 {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
