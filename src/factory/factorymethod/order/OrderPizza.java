package factory.factorymethod.order;


import factory.factorymethod.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class OrderPizza {

    /**
     * 定义一个抽象方法createPizza，让各个工厂子类自己实现
     * @param orderType
     * @return
     */
    abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        Pizza pizza;
        String orderType;

        do {
            orderType = getType();
            // 抽象方法由工厂子类完成
            pizza = createPizza(orderType);

            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购披萨失败");
            }
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strIn.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
