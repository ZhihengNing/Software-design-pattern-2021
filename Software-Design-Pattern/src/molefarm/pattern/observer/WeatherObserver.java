package molefarm.pattern.observer;

import molefarm.common.MoleFarm;
import molefarm.common.status.FarmBlockStatus;
import molefarm.pattern.adapter.conc.MoleAdapter;
import molefarm.pattern.adapter.conc.WeatherAdapter;
import molefarm.pattern.iterator.conc.FarmIterator;

import java.util.Set;

/**
 * 天气状态
 */
public class WeatherObserver {

    private MoleAdapter mole=MoleAdapter.getInstance();

    private MoleFarm moleFarm = mole.getMoleFarm();

    private WeatherObserver(){
    }

    public static WeatherObserver getInstance(){
        return new WeatherObserver();
    }
    /**
     * 观察天气
     */
    public void observer(WeatherAdapter weatherAdapter) {
        if ("雨天".equals(weatherAdapter.getWeather())) {
            //下雨天去除干旱状态
            FarmIterator iterator = moleFarm.getIterator();
            while (iterator.hasNext()) {
                Set<FarmBlockStatus> statusSet = iterator.next().getBlockStatusSet();
                statusSet.remove(FarmBlockStatus.DROUGHT);
            }
        } else if ("虫灾".equals(weatherAdapter.getWeather())) {
            FarmIterator iterator = moleFarm.getIterator();
            while (iterator.hasNext()) {
                Set<FarmBlockStatus> statusSet = iterator.next().getBlockStatusSet();
                statusSet.add(FarmBlockStatus.INSECT_DISASTER);
            }
        }
    }

}
