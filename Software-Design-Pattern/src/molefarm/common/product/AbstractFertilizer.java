package molefarm.common.product;

import molefarm.common.status.product.Level;

import java.util.Objects;

/**
 * 抽象农场肥料
 */
public abstract class AbstractFertilizer implements IProduct {
    /**
     * 名字
     */
    protected String name;
    /**
     * 等级
     */
    protected Level level;
    /**
     * 价格
     */
    protected Double price;

    public abstract Double getPrice();

    public abstract String getName();

    public abstract Integer fertilizerBehavior(int status);

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
