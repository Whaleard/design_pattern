package adapter.objectadapter;

import adapter.classadapter.IVoltage5V;

/**
 * 适配器类
 */
public class VoltageAdapter implements IVoltage5V {

    /**
     * 关联关系-聚合
     */
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (voltage220V != null) {
            // 获取220V电压
            int src = voltage220V.output220V();
            dst = src / 44;
            System.out.println("适配完成，输出的电压为：" + dst + "伏");
        }

        return dst;
    }
}
