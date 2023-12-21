package molefarm.pattern.state;

import molefarm.common.MoleFarmBlock;
import molefarm.pattern.adapter.conc.WeatherAdapter;

public class Context {
    //当前天气状态
    private WeatherAdapter weather;
    //选取的农田块
    private MoleFarmBlock farmBlock;

    public Context(WeatherAdapter weather, MoleFarmBlock farmBlock){
        this.farmBlock=farmBlock;
        this.weather = weather;
    }
    //浇水
    public void watering() {
        weather.watering(farmBlock);
    }
    //除虫
    public void disInsection(){
        weather.disInsection(farmBlock);
    }
}
