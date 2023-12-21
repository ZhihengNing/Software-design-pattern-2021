package molefarm.common.product.fertilizer;

import molefarm.common.product.AbstractFertilizer;
import molefarm.common.status.product.Level;

/**
 * 初级肥料
 */
public class PrimaryFertilizer extends AbstractFertilizer {
    private String name = "初级肥料";

    private Double price = 2.0;

    private Level level = Level.PRIMARY_LEVEL;

    @Override
    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer fertilizerBehavior(int status) {
        return Math.min(status + 1, 7);
    }


    public Level getLevel() {
        return level;
    }

}
