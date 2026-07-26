package iterator;

import java.util.Iterator;
import java.util.List;

public class OutputImpl {

    List<College> collegeList;

    public OutputImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    /**
     * 遍历学院同时调用遍历学院中系的方法
     */
    public void printCollege() {
        // Java中的List已经重写了iterator方法
        Iterator<College> iterator = collegeList.iterator();
        while (iterator.hasNext()) {
            College college = iterator.next();
            System.out.println(college.getName());
            printDepartment(college.createIterator());
        }
    }

    /**
     * 遍历学院中的系
     * @param iterator
     */
    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department department = (Department) iterator.next();
            System.out.println(department.getName());
        }
    }
}
