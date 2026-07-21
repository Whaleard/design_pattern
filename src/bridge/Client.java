package bridge;

public class Client {
    public static void main(String[] args) {
        Phone phone = new FoldedPhone(new XiaoMi());

        phone.open();
        phone.close();
        phone.call();

        System.out.println("==============================");

        Phone phone2 = new FoldedPhone(new Vivo());

        phone2.open();
        phone2.close();
        phone2.call();
    }
}
