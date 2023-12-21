package molefarm.pattern.state.conc;

import molefarm.common.MoleFarmBlock;
import molefarm.common.status.FarmBlockStatus;
import molefarm.pattern.adapter.conc.WeatherAdapter;

public class InsectDamageWeather extends WeatherAdapter {
    private final String weatherStatus="虫灾";

    @Override
    public String getWeather() {
        return weatherStatus;
    }

    @Override
    public void watering(MoleFarmBlock farmBlock) {
        wateringCan.ToolBehavior();
        farmBlock.getBlockStatusSet().removeIf((s)->s.equals(FarmBlockStatus.DROUGHT));
    }

    @Override
    public void disInsection(MoleFarmBlock farmBlock) {
        if (farmBlock.getBlockStatusSet().removeIf(s -> s.equals(FarmBlockStatus.INSECT_DISASTER))) {
            pesticide.ToolBehavior();
        } else {
            System.out.println("就算是虫灾天，喷洒农药也要适量哦");
        }
    }
}
