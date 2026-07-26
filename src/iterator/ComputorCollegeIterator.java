package iterator;

import java.util.Iterator;

public class ComputorCollegeIterator implements Iterator {

    /**
     * 这里需要知道要遍历的元素以怎样的方式存放
     */
    Department[] departments;

    /**
     * 遍历的位置
     */
    int position = 0;

    public ComputorCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    /**
     * 判断是否还有下一个元素
     * @return
     */
    @Override
    public boolean hasNext() {
        if (position > departments.length || departments[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }

    /**
     * 删除的方法默认空实现
     */
    @Override
    public void remove() {

    }
}
