package molefarm.common.product.seed;

import molefarm.common.product.AbstractSeed;
import molefarm.common.status.product.Color;
import molefarm.common.status.product.Size;

/**
 * 草莓种子
 */
public class StrawberrySeed extends AbstractSeed implements Cloneable {
    /**
     * 名字
     */
    private final String name = "草莓种子";
    /**
     * 颜色
     */
    private final Color color = Color.BLACK;
    /**
     * 大小
     */
    private final Size size = Size.BIG;
    /**
     * 生长周期
     */
    private final String growthCycle = "90天";
    /**
     * 价格
     */
    private final Double price = 12.0;

    public StrawberrySeed() {
    }


    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public Double getPrice() {
        return price;
    }
}
