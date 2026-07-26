package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College {

    List<Department> departmentList;

    public InfoCollege() {
        departmentList = new ArrayList<>();
        departmentList.add(new Department("信息安全专业", "信息安全专业"));
        departmentList.add(new Department("网络安全专业", "网络安全专业"));
        departmentList.add(new Department("服务器安全专业", "服务器安全专业"));
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departmentList.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoColleageIterator(departmentList);
    }
}
