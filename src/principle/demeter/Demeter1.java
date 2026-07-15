package principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class Demeter1 {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

/**
 * 学校总部员工类
 */
class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

/**
 * 学院员工类
 */
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

/**
 * 学院员工管理类
 */
class CollegeManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id=" + i);
            list.add(emp);
        }
        return list;
    }
}

/**
 * 学校员工管理类
 *
 * 分析：
 *  1、SchoolManager类的直接朋友类有Employee、CollegeManager。
 *  2、CollegeEmployee不是直接朋友，而是一个陌生类，这样违背了迪米特法则。
 */
class SchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校总部员工id=" + i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee(CollegeManager sub) {
        // CollegeEmployee是以局部变量方式出现在SchoolManager，不是SchoolManager的直接朋友，违反了迪米特法则。
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("--------------学院员工--------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }

        List<Employee> list2 = this.getAllEmployee();
        System.out.println("--------------学校总部员工--------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}