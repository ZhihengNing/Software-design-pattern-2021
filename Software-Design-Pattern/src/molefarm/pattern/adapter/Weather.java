package molefarm.pattern.adapter;

/**
 * 天气类
 */
public abstract class Weather{
    /*
    天气状况
     */
    protected String weatherStatus;
    /**
     * 获取天气状况
     * @return
     */
    public String getWeatherStatus() {
        return weatherStatus;
    }

}
