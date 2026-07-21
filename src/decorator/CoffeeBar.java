package decorator;

public class CoffeeBar {
    public static void main(String[] args) {
        // 1、点一杯美式
        Drink order = new Americano();
        System.out.println("费用1：" + order.cost());
        System.out.println("描述：" + order.getDes());

        // 2、加入一份牛奶
        order = new Milk(order);
        System.out.println("加入一份牛奶 费用：" + order.cost());
        System.out.println("加入一份牛奶 描述：" + order.getDes());

        // 3、加入一份巧克力
        order = new Chocolate(order);
        System.out.println("加入一份牛奶 加入一份巧克力 费用：" + order.cost());
        System.out.println("加入一份牛奶 加入一份巧克力 描述：" + order.getDes());

        // 3、加入一份巧克力
        order = new Chocolate(order);
        System.out.println("加入一份牛奶 加入2份巧克力 费用：" + order.cost());
        System.out.println("加入一份牛奶 加入2份巧克力 描述：" + order.getDes());
    }
}
