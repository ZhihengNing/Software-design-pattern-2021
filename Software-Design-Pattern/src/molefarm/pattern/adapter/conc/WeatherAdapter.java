package molefarm.pattern.adapter.conc;

import molefarm.common.MoleFarmBlock;
import molefarm.common.product.tool.Pesticide;
import molefarm.common.product.tool.WateringCan;
import molefarm.pattern.adapter.Target;
import molefarm.pattern.adapter.Weather;
import molefarm.pattern.state.conc.CloudyWeather;
import molefarm.pattern.state.conc.InsectDamageWeather;
import molefarm.pattern.state.conc.RainWeather;
import molefarm.pattern.state.conc.SunnyWeather;

import java.util.Random;

/**
 * 天气适配器
 */
public class WeatherAdapter extends Weather implements Target {

    public static MoleAdapter mole=MoleAdapter.getInstance();

    public static WateringCan wateringCan= mole.getFarmWarehouse().getWateringCan();

    public static Pesticide pesticide= mole.getFarmWarehouse().getPesticide();

    public static WeatherAdapter adapter;
    //随机跳转天气
    public static WeatherAdapter changeWeather(){
        Random random = new Random();
        int ran = random.nextInt(4);
        if(ran==0) {
            return new SunnyWeather();
        }else if(ran==1){
            return new RainWeather();
        }else if(ran==2){
            return new InsectDamageWeather();
        }
        else {
            return new CloudyWeather();
        }
    }
    /**
     * 获取天气
     * @return
     */
    @Override
    public String getWeather() {
        return getWeatherStatus();
    }
    public static WeatherAdapter getInstance(){
        return adapter;
    }

    public void watering(MoleFarmBlock farmBlock){}

    public void disInsection(MoleFarmBlock farmBlock){}
}
