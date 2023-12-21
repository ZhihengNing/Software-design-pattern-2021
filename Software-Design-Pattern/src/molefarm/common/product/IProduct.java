package molefarm.common.product;

import molefarm.common.status.product.Color;
import molefarm.common.status.product.Level;
import molefarm.common.status.product.Size;

/**
 * 我也不知道为什么要写这个接口，先写上去
 */
public interface IProduct {
    /**
     * 获取价格
     *
     * @return
     */
    default Double getPrice() {
        return null;
    }

    /**
     * 获取名字
     *
     * @return
     */
    default String getName() {
        return null;
    }

    /*
    获取颜色
     */
    default Color getColor() {
        return null;
    }

    /**
     * 获取大小
     *
     * @return
     */
    default Size getSize() {
        return null;
    }

    /*
    获取生产周期
     */
    default String getGrowthCycle() {
        return null;
    }

    /**
     * 获取肥料等级
     *
     * @return
     */
    default Level getLevel() {
        return null;
    }


}
