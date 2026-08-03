package observer;

public class CurrentConditions implements Observer {

    private float temperature;

    private float pressure;

    private float humidity;

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("今日温度: " + temperature + "，今日气压: " + pressure + "，今日湿度: " + humidity);
    }
}
