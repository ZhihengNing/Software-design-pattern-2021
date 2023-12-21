package molefarm.common.product.fertilizer;

import molefarm.common.product.AbstractFertilizer;
import molefarm.common.status.product.Level;

/**
 * 中级肥料
 */
public class MiddleFertilizer extends AbstractFertilizer {
    private String name = "中级肥料";
    private Double price = 5.0;

    private Level level = Level.MIDDLE_LEVEL;

    @Override
    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer fertilizerBehavior(int status) {
        return Math.min(status + 2, 7);
    }

    public Level getLevel() {
        return level;
    }
}
