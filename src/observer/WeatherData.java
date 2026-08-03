package observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class WeatherData implements Subject {

    private float temperature;

    private float pressure;

    private float humidity;

    /**
     * 观察者集合
     */
    private List<Observer> observerList;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void dataChange() {
        // 调用接入方的update方法
        notifyObservers();
    }

    /**
     * 更新数据
     * @param temperature
     * @param pressure
     * @param humidity
     */
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        // 调用dataChange方法，将最新的消息推送给接入方currentConditions
        dataChange();
    }

    /**
     * 注册一个观察者
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    /**
     * 移除一个观察者
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    /**
     * 遍历所有的观察者并通知
     */
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).update(this.temperature, this.pressure, this.humidity);
        }
    }
}
