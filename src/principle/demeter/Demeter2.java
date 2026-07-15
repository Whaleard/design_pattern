package principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class Demeter2 {
    public static void main(String[] args) {
        SchoolManager2 schoolManager2 = new SchoolManager2();
        schoolManager2.printAllEmployee(new CollegeManager2());
    }
}

/**
 * 学校总部员工类
 */
class Employee2 {
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
class CollegeEmployee2 {
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
class CollegeManager2 {
    public List<CollegeEmployee2> getAllEmployee() {
        List<CollegeEmployee2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee2 emp = new CollegeEmployee2();
            emp.setId("学院员工id=" + i);
            list.add(emp);
        }
        return list;
    }

    /**
     * 分析：将输出学院员工的方法，封装到CollegeManager类中。
     */
    public void printAllEmployee() {

        List<CollegeEmployee2> list = this.getAllEmployee();
        System.out.println("--------------学院员工--------------");
        for (CollegeEmployee2 e : list) {
            System.out.println(e.getId());
        }
    }
}

/**
 * 学校员工管理类
 */
class SchoolManager2 {
    public List<Employee2> getAllEmployee() {
        List<Employee2> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Employee2 emp = new Employee2();
            emp.setId("学校总部员工id=" + i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee(CollegeManager2 sub) {
        sub.printAllEmployee();

        List<Employee2> list = this.getAllEmployee();
        System.out.println("--------------学校总部员工--------------");
        for (Employee2 e : list) {
            System.out.println(e.getId());
        }
    }
}