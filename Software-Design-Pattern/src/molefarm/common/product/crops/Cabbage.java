package molefarm.common.product.crops;

import molefarm.common.product.AbstractCrops;
import molefarm.common.status.product.Color;
import molefarm.common.status.product.Size;

/**
 * 白菜🥦
 */
public class Cabbage extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "白菜\uD83E\uDD66";
    /**
     * 颜色
     */
    private final Color color = Color.GREEN;
    /**
     * 大小
     */
    private final Size size = Size.MEDIUM;
    /**
     * 价格
     */
    private final Double price = 5.0;

    public Cabbage() {
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

    @Override
    public String getName() {
        return name;
    }

}
