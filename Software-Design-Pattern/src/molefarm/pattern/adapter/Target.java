package molefarm.pattern.adapter;

/**
 * 适配器模式中的目标接口
 */
public interface Target {

    default Double getMoleDou(){return null;}

    default void setMoleDou(Double money){}

    default String getWeather() {return null;}
}
