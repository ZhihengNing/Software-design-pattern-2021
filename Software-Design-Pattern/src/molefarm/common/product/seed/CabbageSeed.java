package molefarm.common.product.seed;

import molefarm.common.product.AbstractSeed;
import molefarm.common.status.product.Color;
import molefarm.common.status.product.Size;

/**
 * 白菜种子
 */
public class CabbageSeed extends AbstractSeed implements Cloneable {
    protected CabbageSeed(String name, Color color, Size size, String growthCycle, Double price) {
        super(name, color, size, growthCycle, price);
    }

    /**
     * 名字
     */
    private String name = "白菜种子";
    /**
     * 颜色
     */
    private Color color = Color.BLACK;
    /**
     * 大小
     */
    private Size size = Size.MEDIUM;
    /**
     * 生长周期
     */
    private String growthCycle = "90天";
    /**
     * 价格
     */
    private Double price = 6.0;

    public CabbageSeed() {
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
