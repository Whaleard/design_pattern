package factory.absfactory.pizza;

public class BJPepperPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("给制作北京胡椒披萨 准备原材料");
    }
}
