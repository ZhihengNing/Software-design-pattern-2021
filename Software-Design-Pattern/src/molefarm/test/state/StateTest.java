package molefarm.test.state;

import molefarm.common.MoleFarmBlock;
import molefarm.pattern.adapter.conc.WeatherAdapter;
import molefarm.pattern.state.Context;

//根据天气状态的变化，浇水和除虫的方法也有变化
public class StateTest {
    private static WeatherAdapter weather;
    //这里天气是随机变化的
    static {
        //变化天气
        weather=WeatherAdapter.changeWeather();
        System.out.println("今日天气："+weather.getWeather());
        System.out.println("---------------------");
    }
    public static void main(String[] args) {
        System.out.println("----调用状态模式ing----");
        //初始化一个农田块
        MoleFarmBlock block=new MoleFarmBlock();
        //初始化上下文
        Context context=new Context(weather,block);

        System.out.println("测试浇水方法...");
        context.watering();
        System.out.print("\n");

        System.out.println("测试除虫方法...");
        context.disInsection();
    }
}
