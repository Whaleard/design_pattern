package principle.inversion;

/**
 * 依赖倒置原则案例二
 */
public class DependencyInversion4 {
    public static void main(String[] args) {
        OpenAndClose2 openAndClose2 = new OpenAndClose2(new ChangHong2());
        openAndClose2.open();
    }
}

/**
 * 方式2：通过构造方法传递依赖
 */
interface IOpenAndClose2 {
    public void open();
}

interface ITV2 {
    public void play();
}

class ChangHong2 implements ITV2 {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

class OpenAndClose2 implements IOpenAndClose2 {
    public ITV2 tv;

    public OpenAndClose2(ITV2 tv) {
        this.tv = tv;
    }

    public void open() {
        tv.play();
    }
}
