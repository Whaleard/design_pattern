package composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {

    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    public College(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }

    @Override
    protected void print() {
        System.out.println("------------------" + this.getName() + "------------------");
        // 遍历
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}
