package principle.ocp;

/**
 * 开闭原则方案二分析：
 */
public class Ocp2 {
    public static void main(String[] args) {
        GraphicEditor2 graphicEditor2 = new GraphicEditor2();
        graphicEditor2.drawShape(new Rectangle2());
        graphicEditor2.drawShape(new Circle2());
    }
}

/**
 * 使用方
 */
class GraphicEditor2 {
    public void drawShape(Shape2 s) {
        s.draw();
    }
}

abstract class Shape2 {
    int m_type;

    public abstract void draw();
}

class Rectangle2 extends Shape2 {
    Rectangle2() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

class Circle2 extends Shape2 {
    Circle2() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("圆形");
    }
}