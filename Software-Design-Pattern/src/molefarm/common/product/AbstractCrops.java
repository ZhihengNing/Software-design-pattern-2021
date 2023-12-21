package molefarm.common.product;

import molefarm.common.status.product.Color;
import molefarm.common.status.product.Size;

import java.util.Objects;

public abstract class AbstractCrops implements IProduct {
    /**
     * 名字
     */
    protected String name;
    /**
     * 颜色
     */
    protected Color color;
    /**
     * 大小
     */
    protected Size size;
    /**
     * 价格
     */
    protected Double price;

    public AbstractCrops() {
    }

    public AbstractCrops(String name, Color color, Size size, Double price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
