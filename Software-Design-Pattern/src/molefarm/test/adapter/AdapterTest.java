package molefarm.test.adapter;

import framework.simplefactory.Mole;
import molefarm.common.MoleFarmBlock;
import molefarm.pattern.adapter.conc.MoleAdapter;
import molefarm.pattern.adapter.conc.WeatherAdapter;

public class AdapterTest {
    private static WeatherAdapter weatherAdapter;

    private Mole mole = new Mole();
    //测试天气适配器
    public static void WeatherTest(){
        System.out.println("----调用适配器模式ing----");
        //随机跳转天气
        weatherAdapter = WeatherAdapter.changeWeather();
        //获取天气
        System.out.println("今日天气为："+weatherAdapter.getWeather());
        MoleFarmBlock moleFarmBlock = new MoleFarmBlock();
        System.out.println("测试除虫方法：");
        //测试除虫方法
        weatherAdapter.disInsection(moleFarmBlock);
        System.out.println("测试浇水方法：");
        //测试浇水方法
        weatherAdapter.watering(moleFarmBlock);
    }
    public static void MoleAdapterTest(){
        MoleAdapter moleAdapter = MoleAdapter.getInstance();
        System.out.println("现存摩尔豆："+moleAdapter.getMole());
        moleAdapter.getMoleDou();
        moleAdapter.getFarmWarehouse();
        moleAdapter.getMoleFarm();
        moleAdapter.setMoleDou(1000.0);
        System.out.println("成功设置摩尔豆为：1000.0");
    }
    public static void main(String[] args) {
        AdapterTest test = new AdapterTest();
        test.WeatherTest();
    }
}
