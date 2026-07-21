package flyweight;

public class ConcreteWebSite extends WebSite {

    /**
     * 网站发布的形式（共享的部分，内部状态）
     */
    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为：" + this.type + "，用户为：" + user.getName());
    }
}
