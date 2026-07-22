package template.hook;

public abstract class SoyaMilk {

    /**
     * 模板方法，final修饰，不让子类覆盖
     */
    final void make() {
        select();
        if (customerWantsCondiments()) {
            addCondiments();
        }
        soak();
        beat();
    }

    void select() {
        System.out.println("第一步：选择上等黄豆");
    }

    /**
     * 添加不同的配料，抽象方法，子类具体实现
     */
    abstract void addCondiments();

    void soak() {
        System.out.println("第三步：黄豆和配料开始浸泡");
    }

    void beat() {
        System.out.println("第四步：黄豆和配料放到豆浆机去打");
    }

    /**
     * 钩子方法：在模板方法模式的父类中，我们可以定义一个方法，它默认不做任何事，子类可以视情况覆盖它，该方法称为钩子方法。
     * @return
     */
    boolean customerWantsCondiments() {
        return true;
    }
}
