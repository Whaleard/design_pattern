package template.hook;

public class PureSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {

    }

    @Override
    boolean customerWantsCondiments() {
        return false;
    }
}
