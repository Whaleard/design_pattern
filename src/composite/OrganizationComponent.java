package composite;

public abstract class OrganizationComponent {

    private String name;

    private String desc;

    protected void add(OrganizationComponent organizationComponent) {
        // 默认实现
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent) {
        // 默认实现
        throw new UnsupportedOperationException();
    }

    public OrganizationComponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    protected abstract void print();
}
