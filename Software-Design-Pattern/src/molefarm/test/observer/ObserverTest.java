package molefarm.test.observer;

import molefarm.pattern.adapter.conc.WeatherAdapter;
import molefarm.pattern.observer.WeatherObserver;

public class ObserverTest {
    private static WeatherAdapter weatherAdapter;
    public static void test(){
        System.out.println("----调用观察者模式ing----");
        weatherAdapter = WeatherAdapter.changeWeather();
        WeatherObserver weatherobserver = WeatherObserver.getInstance();
        weatherobserver.observer(weatherAdapter);
        System.out.println("观察到天气为："+weatherAdapter.getWeather());
    }
    public static void main(String[] args) {
        test();
    }
}
