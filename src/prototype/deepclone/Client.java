package prototype.deepclone;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType d = new DeepProtoType();
        d.name = "宋江";
        d.deepCloneableTarget = new DeepCloneableTarget("大牛", "大牛的类");

        // 使用clone方法完成深拷贝
        DeepProtoType d2 = (DeepProtoType) d.clone();

        System.out.println("d.name=" + d.name + " d.deepCloneableTarget=" + d.deepCloneableTarget.hashCode());
        System.out.println("d2.name=" + d2.name + " d2.deepCloneableTarget=" + d2.deepCloneableTarget.hashCode());

        // 通过序列化实现深拷贝
        DeepProtoType d3 = (DeepProtoType) d.deepClone();

        System.out.println("d.name=" + d.name + " d.deepCloneableTarget=" + d.deepCloneableTarget.hashCode());
        System.out.println("d3.name=" + d3.name + " d3.deepCloneableTarget=" + d3.deepCloneableTarget.hashCode());
    }
}
