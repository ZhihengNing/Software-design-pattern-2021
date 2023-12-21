package molefarm.common.product.fertilizer;

import molefarm.common.product.AbstractFertilizer;
import molefarm.common.status.product.Level;

/**
 * 高级肥料
 */
public class AdvancedFertilizer extends AbstractFertilizer {
    private String name = "高级肥料";

    private Double price = 10.0;

    private Level level = Level.HIGH_LEVEL;

    @Override
    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer fertilizerBehavior(int status) {
        return Math.min(status + 3, 7);
    }

    public Level getLevel() {
        return level;
    }
}
