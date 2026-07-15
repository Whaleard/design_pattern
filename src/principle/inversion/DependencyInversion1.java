package principle.inversion;

/**
 * 依赖倒置原则方案一分析：
 *  1、实现简单。
 *  2、如果我们获取的对象是微信、短信等等，则需新增类，同时Person类也要增加相应的接收方法。
 *  3、解决思路：引入一个抽象的接口IReceiver，表示接收者，这样Person类与接口IReceiver发生依赖。
 *  4、因为Email、微信等属于接收的范围，他们各自实现IReceiver接口，这样就符合依赖倒置原则。
 */
public class DependencyInversion1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息：hello world";
    }
}

/**
 * 完成Person接收消息的功能
 */
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
