package observer;

public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        // 创建观察者
        CurrentConditions currentConditions = new CurrentConditions();

        // 注册到WeatherData
        weatherData.registerObserver(currentConditions);

        System.out.println("通知各个观察者，天气数据已更新");
        weatherData.setData(10f, 20f, 30f);
    }
}
