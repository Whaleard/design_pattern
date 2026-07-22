package template.hook;

public class PeanntSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        System.out.println("第二步：加入上好的花生");
    }
}
