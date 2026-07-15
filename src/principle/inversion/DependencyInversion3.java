package principle.inversion;

/**
 * 依赖倒置原则案例一
 */
public class DependencyInversion3 {
    public static void main(String[] args) {
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.open(new ChangHong());
    }
}

/**
 * 方式1：通过接口传递实现依赖
 */
interface IOpenAndClose {
    public void open(ITV tv);
}

interface ITV {
    public void play();
}

class ChangHong implements ITV {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

class OpenAndClose implements IOpenAndClose {
    public void open(ITV tv) {
        tv.play();
    }
}
