package molefarm.common.product;

import molefarm.common.status.product.Color;
import molefarm.common.status.product.Size;

import java.util.Objects;

/**
 * 抽象农场种子
 */
public abstract class AbstractSeed implements IProduct {
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
     * 生长周期
     */
    protected String growthCycle;
    /**
     * 价格
     */
    protected Double price;


    protected AbstractSeed() {
    }

    /**
     * 构造方法
     *
     * @param name
     * @param color
     * @param size
     * @param growthCycle
     * @param price
     */
    protected AbstractSeed(String name, Color color, Size size, String growthCycle, Double price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.growthCycle = growthCycle;
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
