package prototype.deepclone;

import java.io.*;

public class DeepProtoType implements Serializable, Cloneable {

    public String name;

    public DeepCloneableTarget deepCloneableTarget;

    public DeepProtoType() {
    }

    /**
     * 深拷贝方式一：使用clone方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep;
        // 这里完成对基本数据类型的克隆
        deep = super.clone();
        // 对引用类型的属性进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    /**
     * 深拷贝方式二：对象序列化（推荐）
     * @return
     */
    public Object deepClone() {
        // 创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 当前这个对象以对象流的方式输出
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType) ois.readObject();

            return copyObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
