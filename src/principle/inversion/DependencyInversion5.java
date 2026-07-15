package principle.inversion;

/**
 * 依赖倒置原则案例三
 */
public class DependencyInversion5 {
    public static void main(String[] args) {
        OpenAndClose3 openAndClose3 = new OpenAndClose3();
        openAndClose3.setTv(new ChangHong3());
        openAndClose3.open();
    }
}

/**
 * 方式3：通过setter方法传递依赖
 */
interface IOpenAndClose3 {
    public void open();
}

interface ITV3 {
    public void play();
}

class ChangHong3 implements ITV3 {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

class OpenAndClose3 implements IOpenAndClose3 {
    public ITV3 tv;

    public void setTv(ITV3 tv) {
        this.tv = tv;
    }

    public void open() {
        tv.play();
    }
}
