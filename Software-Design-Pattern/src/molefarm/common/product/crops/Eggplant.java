package molefarm.common.product.crops;

import molefarm.common.product.AbstractCrops;
import molefarm.common.status.product.Color;
import molefarm.common.status.product.Size;

/**
 * 茄子🍆
 */
public class Eggplant extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "茄子\uD83C\uDF46";
    /**
     * 颜色
     */
    private final Color color = Color.PURPLE;
    /**
     * 大小
     */
    private final Size size = Size.MEDIUM;
    /**
     * 价格
     */
    private final Double price = 10.0;

    public Eggplant() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
